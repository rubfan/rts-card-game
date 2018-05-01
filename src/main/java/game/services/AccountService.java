package game.services;

import game.controllers.dto.AccountDto;
import game.controllers.dto.RoomDto;
import game.controllers.dto.UserDto;
import game.repositories.entities.UserEntity;

import javax.inject.Inject;

public interface AccountService {

    void createAccount(Integer userId);
//    void setRoomForAccount(RoomDto room);
//    void deleteRoomFromAccount(RoomDto room);

}
