package org.kbss.webdb.spring.config.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.kbss.webdb.services.api.account.AccountResourceImpl;
import org.kbss.webdb.spring.config.rest.exceptions.mapper.ClientExceptionMapper;
import org.kbss.webdb.spring.config.rest.exceptions.mapper.ThrowableMapper;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.web.filter.RequestContextFilter;

/**
 * @author Serhii Krivtsov
 * @since 0.1
 */
public class ManagerRestApplication extends ResourceConfig {

    public ManagerRestApplication() {
        super(
                ClientExceptionMapper.class,
                ThrowableMapper.class,
                AccountResourceImpl.class
        );
        register(RequestContextFilter.class);
        register(JacksonJsonProvider.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        registerLoggingFilter();
    }

    private void registerLoggingFilter() {
        SLF4JBridgeHandler.install();
        java.util.logging.Logger juLogger = java.util.logging.Logger.getLogger(LoggingFilter.class.getName());
        this.register(new LoggingFilter(juLogger, true));
    }
}
