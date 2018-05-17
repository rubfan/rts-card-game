package game.controllers.impl;

import game.controllers.AccountCardController;
import game.services.AccountCardService;
import jdk.internal.instrumentation.InstrumentationMethod;
//import jdk.nashorn.internal.parser.JSONParser;
//import jdk.nashorn.internal.runtime.JSONListAdapter;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/account")
public class AccountCardControllerImpl implements AccountCardController {

    @Inject
    public AccountCardService accountCardService;


    @Override
    @GET
    @Path("/{account_id}/card/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllowAccountCards(@PathParam("account_id") Integer accountId) {
        List<Integer> allowCards = accountCardService.getAllowAccountCards(accountId);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, allowCards.toString());
        return Response.ok(allowCards.toString()).build();
    }

    //TODO: change hardCode to real elements
    @Override
    @GET
    @Path("/{account_id}/card/{card_id}/apply")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response cardApply(@PathParam("account_id") Integer accountId, @PathParam("card_id") Integer cardId) {
        return Response.ok().status(200).build();
    }
}
