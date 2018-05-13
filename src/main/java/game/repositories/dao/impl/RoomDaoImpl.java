package game.repositories.dao.impl;

import game.repositories.dao.RoomDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.AccountEntity;
import game.repositories.entities.RoomEntity;
import game.repositories.entities.UserEntity;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * @author ruslangramatic on 4/16/18.
 */
public class RoomDaoImpl implements RoomDao {

    public List<RoomEntity> getListOfRooms() {
        return new QueryHelper<List<RoomEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<RoomEntity> rooms = new LinkedList<>();
                ResultSet rs = statement.executeQuery(
                        "select r.id, r.name, r.description, r.account_1_id, r.account_2_id, r.start_game_time, "+
                        "a1.user_id 'user_1_id', " +
                        "a2.user_id 'user_2_id', " +
                        "u1.name 'user_1_name' , " +
                        "u2.name 'user_2_name' " +
                        "from Room r " +
                        "left join Account a1 on r.account_1_id = a1.id " +
                        "left join Account a2 on r.account_2_id = a2.id " +
                        "left join User u1 on u1.id = a1.user_id " +
                        "left join User u2 on u2.id = a2.user_id"
                );
                while(rs.next()) {

                    RoomEntity room = new RoomEntity();
                    room.setId(rs.getInt("id"));
                    room.setName(rs.getString("name"));
                    room.setDescription(rs.getString("description"));
                    room.setStart_game_time(rs.getTime("start_game_time"));
                    if(rs.getInt("account_1_id") != 0) {
                        room.setAccount1(prepareAccount(rs, 1, rs.getInt("account_1_id")));
                    }
                    if(rs.getInt("account_2_id") != 0) {
                        room.setAccount2(prepareAccount(rs, 2, rs.getInt("account_2_id")));
                    }
                    rooms.add(room);
                }
                returnResult(rooms);
            }
        }.run();
    }

    private AccountEntity prepareAccount(ResultSet rs, Integer userNumber, Integer id) throws SQLException {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(id);
        if (rs.getInt("user_" + userNumber + "_id") != 0) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(rs.getInt("user_" + userNumber + "_id"));
            userEntity.setName(rs.getString("user_" + userNumber + "_name"));
            accountEntity.setUser(userEntity);
        }
        return accountEntity;
    }

    @Override
    public void joinRoom(Integer roomId, Integer accountId, Integer slotNumber) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Room SET account_?_id=? WHERE id=?;");
                pstmt.setInt(1, slotNumber);
                pstmt.setInt(2, accountId);
                pstmt.setInt(3, roomId);
                pstmt.executeUpdate();
                connection.commit();
            }
        }.run();
    }

    @Override
    public void leaveRoom(Integer roomId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Room SET account_1_id=NULL, account_2_id=NULL, start_game_time=NULL WHERE id=?;");
                pstmt.setInt(1, roomId);
                int status = pstmt.executeUpdate();
                connection.commit();
            }
        }.run();
    }

    @Override
    public Boolean checkGameTime(Integer roomId) {
        return 60 > new QueryHelper<Integer>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT TIMESTAMPDIFF(MINUTE,(Select start_game_time from Room where id=?),now()) time;");
                pstmt.setInt(1, roomId);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    returnResult(rs.getInt("time"));
                }
            }
        }.run();
    }

    @Override
    public Integer getFreeAccountNumberForQuery(Integer roomId) {
        return new QueryHelper<Integer>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                ResultSet rs = statement.executeQuery(
                        "SELECT a.account_1_id, a.account_2_id from Room a where id="+ roomId);
                if(rs.next()) {
                    Integer acc1 = rs.getInt("account_1_id");
                    Integer acc2 = rs.getInt("account_2_id");
                    if(acc1 != 0 && acc2 != 0) {
                        returnResult(0);
                    } else if(acc1 == 0) {
                        returnResult(1);
                    } else {
                        returnResult(2);
                    }
                } else {
                    returnResult(0);
                }
            }
        }.run();
    }

}
