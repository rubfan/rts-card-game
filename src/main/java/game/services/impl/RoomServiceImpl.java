package game.services.impl;

import game.controllers.dto.AccountDto;
import game.controllers.dto.RoomDto;
import game.controllers.dto.UserDto;
import game.repositories.dao.AccountDao;
import game.repositories.dao.RoomDao;
import game.repositories.entities.AccountEntity;
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
                setName(roomEntity.getName());
                setDescription(roomEntity.getDescription());
                if(roomEntity.getAccount1() != null) {
                    setAccount1(prepareAccount(roomEntity.getAccount1(),
                            roomEntity.getAccount1().getId()));
                }
                if(roomEntity.getAccount2() != null) {
                    setAccount2(prepareAccount(roomEntity.getAccount2(),
                            roomEntity.getAccount2().getId()));
                }
                if(!roomDao.checkGameTime(roomEntity.getId())){
                    roomDao.leaveRoom(roomEntity.getId());
                }
            }});
        });
        return rooms;
    }

    private AccountDto prepareAccount(AccountEntity accountEntity, Integer id) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(id);
        if (accountEntity.getUser() != null) {
            UserDto userDto = new UserDto();
            userDto.setId(accountEntity.getUser().getId());
            userDto.setName(accountEntity.getUser().getName());
            accountDto.setUser(userDto);
        }
        return accountDto;
    }

    @Override
    public void joinRoom(UserDto user, Integer roomId) {
        accountDao.setRoomForAccount(user.getId(),roomId);
        roomDao.joinRoom(roomId, accountDao.getAccountIdByUserId(user.getId()), roomDao.getFreeAccountNumberForQuery(roomId));
        roomDao.setStartTime(roomId);
    }

    @Override
    public void leaveRoom(Integer roomId, UserDto user) {
        roomDao.leaveRoom(roomId);
        accountDao.deleteRoomFromAccount(user.getId());
    }
}
