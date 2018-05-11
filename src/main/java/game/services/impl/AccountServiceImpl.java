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

            if(accountEntity.getRoom().getAccount1()!=null) {
                //create object Account1
                AccountDto accountDto1 = new AccountDto();
                accountDto1.setId(accountEntity.getRoom().getAccount1().getId());
                //create object User1 for Account1
                UserDto userDto1 = new UserDto();
                userDto1.setId(accountEntity.getRoom().getAccount1().getUser().getId());
                userDto1.setName(accountEntity.getRoom().getAccount1().getUser().getName());
                accountDto1.setUser(userDto1);
                roomDto.setAccount1(accountDto1);
                roomDto.setAccount1(accountDto1);
            }


            if(accountEntity.getRoom().getAccount2()!=null) {
                //create object Account2
                AccountDto accountDto2 = new AccountDto();
                accountDto2.setId(accountEntity.getRoom().getAccount2().getId());
                //create object User2 for Account2
                UserDto userDto2 = new UserDto();
                userDto2.setId(accountEntity.getRoom().getAccount2().getUser().getId());
                userDto2.setName(accountEntity.getRoom().getAccount2().getUser().getName());
                accountDto2.setUser(userDto2);
                roomDto.setAccount2(accountDto2);
            }
            accountDto.setRoom(roomDto);
        }
        return accountDto;
    }






}
