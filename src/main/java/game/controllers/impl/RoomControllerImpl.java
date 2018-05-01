package game.controllers.impl;

import game.controllers.RoomController;
import game.controllers.dto.RoomDto;
import game.controllers.dto.UserDto;
import game.services.RoomService;
import game.services.UserService;

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
    @Inject
    public UserService userService;

    @GET
    @Path("list")
    public List<RoomDto> getRoomList() {
        List<RoomDto> roomList = roomService.getListOfRooms();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, roomList.toString());
        return roomList;
    }

    @GET
    @Path("{roomId}/join")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response joinRoom(@PathParam("roomId") String roomId, @CookieParam("token") String token) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"room=" + roomId);
        UserDto user = userService.getUserByToken(token);
        roomService.joinRoom(user, Integer.parseInt(roomId));
        return Response.status(200).entity("User Entered").build();
    }

    @GET
    @Path("{roomId}/exit")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response exitRoom(@PathParam("roomId") String roomId, @CookieParam("token") String token) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"room=" + roomId);
        roomService.leaveRoom(Integer.parseInt(roomId),userService.getUserByToken(token));
        return Response.status(200).entity("User Left").build();
    }
}

