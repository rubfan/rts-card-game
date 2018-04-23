package game.repositories.dao.impl;

import game.repositories.dao.RoomDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.RoomEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                        rs.getInt("account_2_id")
                    );
                    rooms.add(room);
                }
            }
        }.run();

        return rooms;
    }
}
