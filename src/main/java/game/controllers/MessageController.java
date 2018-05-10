package game.controllers;

import game.controllers.dto.MessageDto;

import javax.ws.rs.core.Response;
import java.util.List;

public interface MessageController {
    List<MessageDto> getMessageList();
//    Response getMessage(Integer fromAccountId, Integer toAccountId, String token);
    Response sendMessage(String text, Integer fromAccountId, Integer toAccountId, String token);
}
