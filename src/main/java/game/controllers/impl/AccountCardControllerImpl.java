package game.controllers.impl;

import game.controllers.AccountCardController;
//import jdk.nashorn.internal.parser.JSONParser;
//import jdk.nashorn.internal.runtime.JSONListAdapter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;
@Path("/account")
public class AccountCardControllerImpl implements AccountCardController {

    //TODO: change hardCode to real elemets
    @Override
    @GET
    @Path("/{account_id}/card/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAccountCards(@PathParam("account_id") Integer accountId) {
        List<Integer> accountCards = new LinkedList<>();
        accountCards.add(1);
        accountCards.add(2);
        accountCards.add(3);
        return Response.ok(accountCards.toString()).build();
    }

    //TODO: change hardCode to real elemets
    @Override
    @GET
    @Path("/{account_id}/card/{card_id}/apply")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response cardApply(@PathParam("account_id") Integer accountId, @PathParam("card_id") Integer cardId) {
        return Response.ok().status(200).build();
    }
}
