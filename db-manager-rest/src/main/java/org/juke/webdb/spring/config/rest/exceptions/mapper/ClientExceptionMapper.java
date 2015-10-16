package org.juke.webdb.spring.config.rest.exceptions.mapper;

import org.juke.webdb.dto.ErrorDto;
import org.juke.webdb.services.exceptions.ClientException;
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
public class ClientExceptionMapper implements ExceptionMapper<ClientException> {
    private static final Logger logger = LoggerFactory.getLogger(ClientExceptionMapper.class);

    @Override
    public Response toResponse(ClientException exception) {
        logger.debug(exception.getMessage(), exception);
        ErrorDto errorDto = new ErrorDto(exception.getMessage(), "CLIENT");
        return Response.status(exception.getStatus()).type(MediaType.APPLICATION_JSON).entity(errorDto).build();
    }
}