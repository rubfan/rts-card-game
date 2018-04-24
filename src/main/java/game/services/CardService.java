package game.services;

import game.controllers.dto.CardDto;

import java.util.List;

public interface CardService {
    List<CardDto> getListOfCards();
}
