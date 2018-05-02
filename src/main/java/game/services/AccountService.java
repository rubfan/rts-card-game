package game.services;

import game.controllers.dto.AccountDto;
import game.controllers.dto.UserDto;

public interface AccountService {

    void createAccount(UserDto user);
    AccountDto getAccountByUser(UserDto user);
//    void setRoomForAccount(RoomDto room);
//    void deleteRoomFromAccount(RoomDto room);

}
