package game.controllers.impl;

import game.controllers.AccountController;
import game.controllers.dto.AccountDto;
import game.services.AccountService;
import game.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/account")
public class AccountControllerImpl implements AccountController {

    @Inject
    public UserService userService;
    @Inject
    public AccountService accountService;

    @GET
    @Path("info")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AccountDto getAccount(@CookieParam("token") Cookie cookie) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, cookie.getValue());
        return accountService.getAccountByUser(userService.getUserByToken(cookie.getValue()));
    }
}