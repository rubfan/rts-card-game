package game.controllers.impl;

import game.controllers.RoomController;
import game.controllers.dto.RoomDto;
import game.services.RoomService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ruslangramatic on 4/19/18.
 */
@Path("/room")
public class RoomControllerImpl implements RoomController {

    @Inject
    public RoomService roomService;

    @GET
    @Path("list")
    public List<RoomDto> getRoomList() {
        List<RoomDto> roomList = roomService.getListOfRooms();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, roomList.toString());
        return roomList;
    }

    @GET
    @Path("{roomId}/enter")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response enterRoom(@PathParam("roomId") String roomId, @CookieParam("token") String token) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"room=" + roomId);

        return Response.status(200).entity("User Entered").build();
    }

    @GET
    @Path("{roomId}/exit")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response exitRoom(@PathParam("roomId") String roomId, @CookieParam("token") String token) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"room=" + roomId);
        return Response.status(200).entity("User Left").build();
    }
}

