package game.controllers.impl;

import game.controllers.MessageController;
import game.controllers.dto.MessageDto;
import game.controllers.dto.UserDto;
import game.services.MessageService;
import game.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/message")
public class MessageControllerImpl implements MessageController {

    @Inject
    public MessageService messageService;
    @Inject
    public UserService userService;

    @GET
    @Path("list")
    public List<MessageDto> getMessagesList() {
        List<MessageDto> messagesList = messageService.getListOfMessages();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messagesList.toString());
        return messagesList;
    }

    @POST
    @Path("/send")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response sendMessage(MessageDto message, @CookieParam("token") Cookie cookie) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"message=" + message.getText());
        UserDto user = userService.getUserByToken(cookie.getValue());
        messageService.sendMessage(message.getText(), user, 10);
        return Response.status(200).entity("User send message").build();
    }

    @GET
    @Path("/room/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<MessageDto> getRoomMessages(@CookieParam("token") Cookie cookie) {
        UserDto user = userService.getUserByToken(cookie.getValue());
        List<MessageDto> messagesOfAccount = messageService.getRoomMessages(user);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messagesOfAccount.toString());
        return messagesOfAccount;
    }
}
