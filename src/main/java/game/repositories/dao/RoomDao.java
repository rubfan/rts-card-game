package game.repositories.dao;

import game.repositories.entities.RoomEntity;

import java.util.List;

/**
 * @author ruslangramatic on 4/20/18.
 */
public interface RoomDao {
    List<RoomEntity> getListOfRooms();
    void joinRoom(Integer roomId, Integer userId, Integer id);
    void leaveRoom(Integer roomId);
    Integer getFreeAccountNumberForQuery(Integer roomId);
    void setStartTime(Integer roomId);
    Boolean checkGameTime(Integer roomId);
}
