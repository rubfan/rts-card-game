package game.repositories.dao;

import game.repositories.entities.RoomEntity;

import java.util.List;

/**
 * @author ruslangramatic on 4/20/18.
 */
public interface RoomDao {
    List<RoomEntity> getListOfRooms();
    void joinRoom();
    void leaveRoom();
}
