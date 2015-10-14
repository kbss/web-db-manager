package org.juke.webdb.spring.config;

import org.juke.webdb.filters.AuthenticationFilter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        Integer status = (Integer) request.getAttribute(AuthenticationFilter.ERROR);

        if (status != null) {
            response.setStatus(status);
            response.setContentLength(0);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentLength(0);
        }

    }
}