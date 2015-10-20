package org.kbss.webdb.spring.config.rest.exceptions.mapper;

import org.kbss.webdb.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Serhii Krivtsov
 */
@Provider
@Singleton
public class ThrowableMapper implements ExceptionMapper<Throwable> {
    private static final Logger logger = LoggerFactory.getLogger(ThrowableMapper.class);

    @Override
    public Response toResponse(Throwable exception) {
        logger.debug(exception.getMessage(), exception);
        ErrorDto errorDto = new ErrorDto(exception.getMessage(), "ERR");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(errorDto).build();
    }
}