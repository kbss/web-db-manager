package org.juke.webdb.spring.config.rest;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.juke.webdb.manager.impl.ManagerResourceImpl;
import org.juke.webdb.services.api.account.AccountResourceImpl;
import org.juke.webdb.spring.config.rest.exceptions.mapper.ClientExceptionMapper;
import org.juke.webdb.spring.config.rest.exceptions.mapper.ThrowableMapper;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.web.filter.RequestContextFilter;

/**
 * @author Serhii Krivtsov
 * @since 12/10/2015
 */
public class ManagerRestApplication extends ResourceConfig {

    public ManagerRestApplication() {
        super(
                ManagerResourceImpl.class,
                RequestContextFilter.class,
                JacksonFeature.class,
                ClientExceptionMapper.class,
                ThrowableMapper.class,
                AccountResourceImpl.class
        );
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        registerLoggingFilter();
    }

    private void registerLoggingFilter() {
        if (!SLF4JBridgeHandler.isInstalled()) {
            SLF4JBridgeHandler.install();
        }
        java.util.logging.Logger juLogger = java.util.logging.Logger.getLogger(LoggingFilter.class.getName());
        this.register(new LoggingFilter(juLogger, true));
    }
}
