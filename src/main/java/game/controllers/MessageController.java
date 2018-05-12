package game.controllers;

import game.controllers.dto.MessageDto;

import javax.ws.rs.core.Response;
import java.util.List;

public interface MessageController {
    List<MessageDto> getMessagesList();
    Response sendMessage(String text, String token);
    List<MessageDto> getMessages(String token);
}
