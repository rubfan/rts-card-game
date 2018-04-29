package game.services;

import game.controllers.dto.RoomDto;

import java.util.List;

/**
 * @author ruslangramatic on 4/20/18.
 */
public interface RoomService {
    List<RoomDto> getListOfRooms();
    void joinRoom();
    void leaveRoom();

}
