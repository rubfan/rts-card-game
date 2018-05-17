package game.repositories.dao;

import game.repositories.entities.CardProductEntity;

import java.util.Collection;
import java.util.List;

public interface CardProductDao {
    Collection<CardProductEntity> getListOfCardProducts();
    List<Integer> getAllowAccountCards();
}
