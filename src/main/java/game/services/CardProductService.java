package game.services;

import game.controllers.dto.CardProductDto;

import java.util.List;

public interface CardProductService {
    List<CardProductDto> getListOfCardProducts();
}
