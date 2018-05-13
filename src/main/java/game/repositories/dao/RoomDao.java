package game.repositories.dao;

import game.repositories.entities.RoomEntity;

import java.util.List;

/**
 * @author ruslangramatic on 4/20/18.
 */
public interface RoomDao {
    List<RoomEntity> getListOfRooms();
    void joinRoom(Integer roomId, Integer accountId, Integer slotNumber);
    void leaveRoom(Integer roomId);
    Integer getFreeAccountNumberForQuery(Integer roomId);
    Boolean checkGameTime(Integer roomId);
}
