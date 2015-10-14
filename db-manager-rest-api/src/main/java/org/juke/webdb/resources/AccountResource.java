package org.juke.webdb.resources;

import org.juke.webdb.dto.AccountDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Serhii Kryvtsov
 * @since 12/10/2015
 */
@Path("account")
public interface AccountResource {

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    AccountDto login(AccountDto loginDto);

    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    AccountDto registerAccount(AccountDto loginDto);

    @DELETE
    @Path("logout")
    void logout();
}
