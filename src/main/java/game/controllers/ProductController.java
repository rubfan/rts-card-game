package game.controllers;

import game.controllers.dto.ProductDto;

import java.util.List;

public interface ProductController {
    List<ProductDto> getProductListByBuildingId(Integer bulildingId);
}