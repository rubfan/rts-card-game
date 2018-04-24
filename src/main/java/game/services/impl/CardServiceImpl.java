package game.services.impl;

import game.controllers.dto.CardDto;
import game.repositories.dao.CardDao;
import game.services.CardService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class CardServiceImpl implements CardService {

    @Inject
    public CardDao cardDao;

    public List<CardDto> getListOfCards(){
        final List<CardDto> cards = new LinkedList<>();
        cardDao.getListOfCards().forEach(cardEntity -> {
            cards.add(new CardDto(){{
                setId(cardEntity.getId());
                setName(cardEntity.getName());
                setDescription(cardEntity.getDescription());
            }});
        });
        return cards;
    }
}
