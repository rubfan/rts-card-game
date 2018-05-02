package game.services.impl;

import game.controllers.dto.AccountDto;
import game.controllers.dto.RoomDto;
import game.controllers.dto.UserDto;
import game.repositories.dao.AccountDao;
import game.repositories.entities.AccountEntity;
import game.repositories.entities.UserEntity;
import game.services.AccountService;

import javax.inject.Inject;

public class AccountServiceImpl implements AccountService {

    @Inject
    public AccountDao accountDao;

    @Override
    public void createAccount(UserDto user) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUser(new UserEntity(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getToken()
         ));
        accountDao.createAccount(accountEntity);

    }

    @Override
    public AccountDto getAccountByUser(UserDto user) {
        UserEntity userEntity = new UserEntity(
                user.getId(),
                user.getName(),
                null,
                user.getToken()
        );
        AccountEntity accountEntity = accountDao.getAccountByUser(userEntity);
        AccountDto accountDto = new AccountDto();
        accountDto.setUser(user);
        accountDto.setId(accountEntity.getId());
        if(accountEntity.getRoom() != null) {
            RoomDto roomDto = new RoomDto();
            roomDto.setId(accountEntity.getRoom().getId());
            roomDto.setName(accountEntity.getRoom().getName());
            roomDto.setDescription(accountEntity.getRoom().getDescription());
            roomDto.setSetStart_game_time(accountEntity.getRoom().getStart_game_time());
            accountDto.setRoom(roomDto);
        }
        return accountDto;
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
