package game.services.impl;

import game.controllers.dto.AccountDto;
import game.controllers.dto.RoomDto;
import game.controllers.dto.UserDto;
import game.repositories.dao.AccountDao;
import game.repositories.entities.AccountEntity;
import game.repositories.entities.UserEntity;
import game.services.AccountService;

import javax.inject.Inject;

public class AccountServiceImpl implements AccountService{

    @Inject
    public AccountDao accountDao;

    @Override
    public void createAccount(Integer userId) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUser_id(userId);
        accountDao.createAccount(accountEntity);

    }

//    @Override
//    public void setRoomForAccount(RoomDto room) {
//        accountDao.setRoomForAccount();
//    }
//
//    @Override
//    public void deleteRoomFromAccount(RoomDto room) {
//        accountDao.deleteRoomFromAccount();
//    }


}
