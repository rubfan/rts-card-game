package game.repositories.dao;

import game.repositories.entities.CardEntity;

import java.util.List;

public interface CardDao {
    List<CardEntity> getListOfCards();
}
