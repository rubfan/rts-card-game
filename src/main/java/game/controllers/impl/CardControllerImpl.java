package game.controllers.impl;

import game.controllers.CardController;
import game.controllers.dto.CardDto;
import game.services.CardService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/card")
public class CardControllerImpl implements CardController {

    @Inject
    public CardService cardService;

    @GET
    @Path("list")
    public List<CardDto> getCardList(){
        List<CardDto> cardList = cardService.getListOfCards();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, cardList.toString());
        return cardList;
    }

}
