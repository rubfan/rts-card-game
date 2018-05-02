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
        final List<RoomEntity> rooms = new LinkedList<>();

        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
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
            }
        }.run();

        return rooms;
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
    public void joinRoom(Integer roomId, Integer userId, Integer id) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Room SET account_?_id=? WHERE id=?;");
                pstmt.setInt(1, id);
                pstmt.setInt(2, userId);
                pstmt.setInt(3, roomId);
                int status = pstmt.executeUpdate();
            }
        }.run();
    }

    @Override
    public void leaveRoom(Integer roomId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Room SET account_1_id=NULL, account_2_id=NULL WHERE id=?;");
                pstmt.setInt(1, roomId);
                int status = pstmt.executeUpdate();
            }
        }.run();
    }

    @Override
    public void setStartTime(Integer roomId) {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Room SET start_game_time=NOW() WHERE id=?;");
                pstmt.setInt(1, roomId);
                int status = pstmt.executeUpdate();
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
                    setResult(rs.getInt("time"));
                }
            }
        }.run();
    }

    @Override
    public Integer getFreeAccountNumberForQuery(Integer roomId) {
        final Integer[] playersInRoom = new Integer[1];
                new QueryHelper() {
                    protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                        ResultSet rs = statement.executeQuery("SELECT (COUNT(a.account_1_id)+COUNT(a.account_2_id)) qty from Room a where id="+ roomId + " and (account_1_id IS NOT NULL or account_2_id IS NOT NULL);");
                        while(rs.next()) {
                            playersInRoom[0] = rs.getInt("qty");
                        }
                    }
                }.run();

                if(playersInRoom[0]==0){
                    return 1;
                }
                else if(playersInRoom[0]==1){
                    return 2;
                }
                else return 0;
            }

}
