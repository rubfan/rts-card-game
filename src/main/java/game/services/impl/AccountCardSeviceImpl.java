package game.services.impl;

import game.repositories.dao.CardProductDao;
import game.services.AccountCardService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AccountCardSeviceImpl implements AccountCardService {

    @Inject
    CardProductDao cardProductDao;

    @Override
    public List<Integer> getAllowAccountCards(Integer accountId) {
        List<Integer> allowCards = cardProductDao.getAllowAccountCards();
        return allowCards;
    }
}
