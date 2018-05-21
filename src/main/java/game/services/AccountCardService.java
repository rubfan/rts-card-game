package game.services;

import java.util.List;

public interface AccountCardService {
    List<Integer> getAllowAccountCards(Integer accountId);
    void cardApply(Integer accountId, Integer cardId);
}
