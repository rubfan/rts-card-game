package game.controllers;


import javax.ws.rs.core.Response;
import java.util.List;

public interface AccountCardController {
    Response getAllowAccountCards(Integer accountId);
    Response cardApply(Integer accountId, Integer cardId);
}
