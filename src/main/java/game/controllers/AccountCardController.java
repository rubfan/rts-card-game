package game.controllers;


import javax.ws.rs.core.Response;
import java.util.List;

public interface AccountCardController {
    List<Integer> getAccountCards(Integer accountId);
    Response.ResponseBuilder cardApply(Integer accountId, Integer cardId);
}
