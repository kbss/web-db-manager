package org.juke.webdb.resources;

import org.juke.webdb.dto.ConnectionDto;
import org.juke.webdb.dto.ConnectionInfoDto;
import org.juke.webdb.dto.QueryDto;
import org.juke.webdb.dto.QueryResultDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author Serhii Krivtsov
 *
 */
@Path("manager")
public interface ManagerResource {

    @POST
    @Path("connect")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    ConnectionInfoDto connect(ConnectionDto connection);

    @POST
    @Path("execute")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    QueryResultDto execute(QueryDto query);
}
