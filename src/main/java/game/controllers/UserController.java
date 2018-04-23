package game.controllers;

import game.controllers.dto.UserDto;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

/**
 * @author ruslangramatic on 4/20/18.
 */
public interface UserController {
    Response loginUser(UserDto user);
    Response logoutUser(Cookie cookie);
    Response createNewUser(UserDto user);
}
