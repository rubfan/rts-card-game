package game.controllers;

import game.controllers.dto.AccountDto;

import javax.ws.rs.core.Cookie;

public interface AccountController {
    AccountDto getAccount(Cookie cookie);
}
