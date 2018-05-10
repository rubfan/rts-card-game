package game.repositories.dao;

import game.repositories.entities.CardProductEntity;

import java.util.Collection;

public interface CardProductDao {
    Collection<CardProductEntity> getListOfCardProducts();
}
