package game.repositories.dao;

import game.repositories.entities.ProductEntity;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> getListOfProductByBuldingId(Integer buildingId);
}
