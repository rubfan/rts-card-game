package game.services;

import game.controllers.dto.RoomDto;
import game.controllers.dto.UserDto;

import java.util.List;

/**
 * @author ruslangramatic on 4/20/18.
 */
public interface RoomService {
    List<RoomDto> getListOfRooms();
    void joinRoom(UserDto user, Integer roomId);
    void leaveRoom(Integer roomId, UserDto user);
}
