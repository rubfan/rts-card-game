package game.services;

import game.controllers.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getListOfProductByBuildingId(Integer buildingId);
}
