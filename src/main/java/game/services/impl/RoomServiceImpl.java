package game.services.impl;

import game.controllers.dto.RoomDto;
import game.repositories.dao.AccountDao;
import game.repositories.dao.RoomDao;
import game.services.RoomService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ruslangramatic on 4/20/18.
 */
public class RoomServiceImpl implements RoomService {

    @Inject
    public RoomDao roomDao;
    @Inject
    public AccountDao accountDao;

    public List<RoomDto> getListOfRooms() {
        final List<RoomDto> rooms = new LinkedList<>();
        roomDao.getListOfRooms().forEach(roomEntity -> {
            rooms.add(new RoomDto(){{
                setId(roomEntity.getId());
                setAccount_1_id(roomEntity.getAccount_1_id());
                setAccount_2_id(roomEntity.getAccount_2_id());
                setName(roomEntity.getName());
                setDescription(roomEntity.getDescription());
                if(!roomDao.checkGameTime(roomEntity.getId())){
                    roomDao.leaveRoom(roomEntity.getId());
                }
            }});
        });
        return rooms;
    }

    @Override
    public void joinRoom(Integer userId, Integer roomId) {
        accountDao.setRoomForAccount(userId,roomId);
        roomDao.joinRoom(roomId, accountDao.getAccountIdByUserId(userId), roomDao.getFreeAccountNumberForQuery(roomId));
        roomDao.setStartTime(roomId);
    }

    @Override
    public void leaveRoom(Integer roomId, Integer userId) {
        roomDao.leaveRoom(roomId);
        accountDao.deleteRoomFromAccount(userId);
    }
}
