package game.services.impl;

import game.controllers.dto.UserDto;
import game.repositories.dao.UserDao;
import game.repositories.dao.impl.UserDaoImpl;
import game.repositories.entities.UserEntity;
import game.services.AccountService;
import game.services.UserService;
import game.utils.RandomString;

import javax.inject.Inject;

/**
 * @autor ruslangramatic on 4/20/18.
 */
public class UserServiceImpl implements UserService {

    @Inject
    public UserDao userDao;

    @Override
    public String loginUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        return userDao.loginUser(userEntity);
    }

    @Override
    public void logoutUser(String token) {
        userDao.logoutUser(token);
    }

    @Override
    public String createNewUser(UserDto user) {
        UserEntity newUser = new UserEntity();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setToken(new RandomString().nextString());
        return userDao.createNewUser(newUser);
    }

    @Override
    public UserDto getUserByToken(String token) {
        UserEntity userEntity = userDao.getUserByToken(token);
        return new UserDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.getToken()
        );
    }


}