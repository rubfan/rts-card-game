package game.repositories.dao.impl;

import game.repositories.dao.RoomDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.RoomEntity;

import java.sql.*;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;


/**
 * @author ruslangramatic on 4/16/18.
 */
public class RoomDaoImpl implements RoomDao {

    public List<RoomEntity> getListOfRooms() {
        final List<RoomEntity> rooms = new LinkedList<RoomEntity>();

        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                ResultSet rs = statement.executeQuery("select * from Room");
                while(rs.next()) {
                    RoomEntity room = new RoomEntity(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("account_1_id"),
                        rs.getInt("account_2_id"),
                        rs.getTime("start_game_time")
                    );
                    rooms.add(room);

                }
            }
        }.run();

        return rooms;
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
                        "SELECT TIMESTAMPDIFF(MINUTE,(Select start_game_time from room where id=?),now()) time;");
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
                        ResultSet rs = statement.executeQuery("SELECT (COUNT(a.account_1_id)+COUNT(a.account_2_id)) qty from room a where id="+ roomId + " and (account_1_id IS NOT NULL or account_2_id IS NOT NULL);");
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
