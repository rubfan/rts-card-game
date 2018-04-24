package game.controllers;

import game.controllers.dto.CardDto;

import java.util.List;

public interface CardController {
    List<CardDto> getCardList();
}
