package org.juke.webdb.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tuckey.web.filters.urlrewrite.RunConfig;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.util.Hashtable;

/**
 * Created by Serhii Kryvtsov
 *
 * @since 03/07/2014.
 */
public class CustomUrlRewriteFilter extends UrlRewriteFilter {


    public static final String LOCAL_ENV = "local";
    public static final String PROPERTY = "webdb.env";
    private static final String CONFIGURATION = "/WEB-INF/urlrewrite_dev.xml";
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUrlRewriteFilter.class);

    private boolean isDevEnvironment() {
        String value = System.getProperty(PROPERTY);
        LOGGER.debug("Environment: {}", value);
        if (LOCAL_ENV.equalsIgnoreCase(value)) {
            return true;
        }
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(replace(filterConfig));
    }

    private FilterConfig replace(FilterConfig filterConfig) {
        if (isDevEnvironment()) {
            LOGGER.debug("Replacing filter configuration...");
            LOGGER.debug("Using file: {}", CONFIGURATION);
            Hashtable<String, String> params = new Hashtable(2);
            params.put("logLevel", "WARN");
            params.put("confPath", CONFIGURATION);
            return new RunConfig(filterConfig.getServletContext(), params);
        }
        LOGGER.debug("Using default url rewrite configuration");
        return filterConfig;
    }
}
