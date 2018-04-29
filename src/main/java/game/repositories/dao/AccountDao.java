package game.repositories.dao;

import game.repositories.entities.AccountEntity;
import game.repositories.entities.RoomEntity;

public interface AccountDao {

    void createAccount(AccountEntity account);
    void setRoomForAccount(AccountEntity account);
    void deleteRoomFromAccount(AccountEntity account);

}
