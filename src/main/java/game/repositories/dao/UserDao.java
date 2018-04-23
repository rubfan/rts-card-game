package game.repositories.dao;

import game.repositories.entities.UserEntity;

/**
 * @author ruslangramatic on 4/20/18.
 */
public interface UserDao {
    String loginUser(UserEntity user);
    void logoutUser(String token);
    String createNewUser(UserEntity user);
}
