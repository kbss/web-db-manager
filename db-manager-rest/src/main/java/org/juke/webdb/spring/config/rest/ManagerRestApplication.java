package org.juke.webdb.spring.config.rest;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.juke.webdb.manager.impl.ManagerResourceImpl;
import org.juke.webdb.spring.config.rest.exceptions.mapper.ThrowableMapper;
import org.springframework.web.filter.RequestContextFilter;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
public class ManagerRestApplication extends ResourceConfig {

    public ManagerRestApplication() {
        super(ManagerResourceImpl.class, RequestContextFilter.class, JacksonFeature.class, ThrowableMapper.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        this.register(new LoggingFilter(java.util.logging.Logger.getLogger(LoggingFilter.class.getName()), true));
    }
}
