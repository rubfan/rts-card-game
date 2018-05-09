package game.controllers.impl;

import game.controllers.CardProductController;
import game.controllers.dto.CardProductDto;
import game.services.CardProductService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/card")
public class CardProductControllerImpl implements CardProductController {
    @Inject
    public CardProductService cardProductService;

    @GET
    @Path("product/list")
    public List<CardProductDto> getListOfCardProducts() {
        List<CardProductDto> cardProductDtoList = cardProductService.getListOfCardProducts();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, cardProductDtoList.toString());
        return cardProductDtoList;
    }
}
