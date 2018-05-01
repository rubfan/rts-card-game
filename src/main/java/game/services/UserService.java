package game.services;

import game.controllers.dto.UserDto;

/**
 * @author ruslangramatic on 4/20/18.
 */
public interface UserService {
    String loginUser(UserDto user);
    void logoutUser(String token);
    String createNewUser(UserDto user);
    UserDto getUserByToken(String token);
}
