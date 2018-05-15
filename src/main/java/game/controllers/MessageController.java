package game.controllers;

import game.controllers.dto.MessageDto;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import java.util.List;

public interface MessageController {
    List<MessageDto> getMessagesList();
    Response sendMessage(MessageDto message, Cookie cookie);
    List<MessageDto> getRoomMessages(Cookie cookie);
}
