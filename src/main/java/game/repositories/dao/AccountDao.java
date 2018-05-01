package game.repositories.dao;

import game.repositories.entities.AccountEntity;
import game.repositories.entities.RoomEntity;

public interface AccountDao {

    void createAccount(AccountEntity account);
    void setRoomForAccount(Integer userId, Integer roomId);
    void deleteRoomFromAccount(Integer userId);
    Integer getAccountIdByUserId(Integer userId);

}
