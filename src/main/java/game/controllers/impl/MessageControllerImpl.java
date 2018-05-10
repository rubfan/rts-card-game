package game.controllers.impl;

import game.controllers.MessageController;
import game.controllers.dto.MessageDto;
import game.controllers.dto.UserDto;
import game.services.MessageService;
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
    public List<MessageDto> getMessagesList() {
        List<MessageDto> messagesList = messageService.getListOfMessages();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messagesList.toString());
        return messagesList;
    }

    @GET
    @Path("/send")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response sendMessage(String text, String token) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"message=" + text);
        UserDto user = userService.getUserByToken(token);
        messageService.sendMessage(text, user, 10);
        return Response.status(200).entity("User send message").build();
    }

    @Override
    public List<MessageDto> getMessages(String token) {
        UserDto user = userService.getUserByToken(token);
        List<MessageDto> messagesOfAcount = messageService.getMessages(user);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messagesOfAcount.toString());
        return messagesOfAcount;
    }
}
