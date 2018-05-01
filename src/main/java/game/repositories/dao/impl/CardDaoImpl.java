package game.repositories.dao.impl;

import game.repositories.dao.CardDao;
import game.repositories.dao.helpers.QueryHelper;
import game.repositories.entities.CardEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CardDaoImpl implements CardDao {

    public List<CardEntity> getListOfCards() {
        final List<CardEntity> cards = new LinkedList<CardEntity>();

        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("use card_battle_rts");
                ResultSet rs = statement.executeQuery("select * from Card");
                while(rs.next()) {
                    CardEntity card = new CardEntity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")
                    );
                    cards.add(card);
                }
            }
        }.run();

        return cards;
    }
}
