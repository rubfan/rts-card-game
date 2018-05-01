package game.controllers.impl;

import game.controllers.MessageController;
import game.controllers.dto.MessageDto;
import game.services.MessageService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/message")
public class MessageControllerImpl implements MessageController{

    @Inject
    public MessageService messageService;

    @GET
    @Path("list")
    public List<MessageDto> getMessageList() {
        List<MessageDto> messageList = messageService.getListOfMessages();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messageList.toString());
        return messageList;
    }
}
