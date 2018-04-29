package game.services.impl;

import game.controllers.dto.AccountDto;
import game.controllers.dto.RoomDto;
import game.controllers.dto.UserDto;
import game.repositories.dao.AccountDao;
import game.repositories.entities.AccountEntity;
import game.services.AccountService;

import javax.inject.Inject;

public class AccountServiceImpl implements AccountService{

    @Inject
    public AccountDao accountDao;

    @Override
    public void createAccount(UserDto user) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUser_id(user.getId());
        accountDao.createAccount(accountEntity);

    }

    @Override
    public void setRoomForAccount(RoomDto room) {

    }

    @Override
    public void deleteRoomFromAccount(RoomDto room) {

    }

}
