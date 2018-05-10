package game.controllers;

import game.controllers.dto.CardProductDto;

import java.util.List;

public interface CardProductController {
    List<CardProductDto> getListOfCardProducts();
}
