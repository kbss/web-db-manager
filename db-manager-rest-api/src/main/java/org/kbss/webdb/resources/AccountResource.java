package org.kbss.webdb.resources;

import org.kbss.webdb.dto.AccountDto;

import javax.ws.rs.*;
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
