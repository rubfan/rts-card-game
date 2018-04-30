package game.controllers;

import game.controllers.dto.MessageDto;

import javax.ws.rs.core.Response;
import java.util.List;

public interface MessageController {
    List<MessageDto> getMessageList();
//    Response getMessage(String fromAccountId, String token);
//    Response sendMessage(String toAccountId, String token);
}
