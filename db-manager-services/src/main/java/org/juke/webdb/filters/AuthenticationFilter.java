package org.juke.webdb.filters;

import org.juke.webdb.context.SecurityContext;
import org.juke.webdb.jpa.dao.UserTokenDao;
import org.juke.webdb.jpa.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Serhii Kryvtsov
 * @since 12/10/2015
 */
public class AuthenticationFilter extends GenericFilterBean {

    public static final String ERROR = "AuthenticationFilter.error";
    public static final Pattern AUTH_PATTERN = Pattern.compile("WebAuth=(.*?);");
    private static final String AUTH_HEADER = "Authorization";
    private static final List<GrantedAuthority> GRANTED_AUTHORITY = new ArrayList<GrantedAuthority>(1) {
        {
            add(new SimpleGrantedAuthority("ROLE_USER"));
        }
    };
    private static Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Inject
    private UserTokenDao userTokenDao;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String token = getToken(request);
        if (token != null) {
            User user = userTokenDao.findUserByToken(token);
            if (user != null) {
                SecurityContext context = new SecurityContext(user, GRANTED_AUTHORITY);
                context.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(context);
            } else {
                logger.debug("Can't find token: {}", token);
                setUnauthorized(request);
            }
        } else {
            logger.debug("Authentication required");
            setUnauthorized(request);
        }
        filterChain.doFilter(request, servletResponse);
    }

    private void setUnauthorized(HttpServletRequest request) {
        request.setAttribute(ERROR, HttpServletResponse.SC_UNAUTHORIZED);
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    private String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader(AUTH_HEADER);
        if (authHeader != null) {
            Matcher matcher = AUTH_PATTERN.matcher(authHeader);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
}
