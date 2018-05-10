package game.controllers.impl;

import game.controllers.MessageController;
import game.controllers.dto.MessageDto;
import game.controllers.dto.UserDto;
import game.services.MessageService;
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

@Path("/message")
public class MessageControllerImpl implements MessageController{

    @Inject
    public MessageService messageService;
    @Inject
    public RoomService roomService;
    @Inject
    public UserService userService;

    @GET
    @Path("list")
    public List<MessageDto> getMessageList() {
        List<MessageDto> messageList = messageService.getListOfMessages();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messageList.toString());
        return messageList;
    }


    @GET
    @Path("/send")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response sendMessage(String text, Integer fromAccountId, Integer toAccountId, String token) {
//        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"room=" + roomId);
        UserDto user = userService.getUserByToken(token);
//        roomService.joinRoom(user, Integer.parseInt(roomId));
        return Response.status(200).entity("User send message").build();
    }
}
