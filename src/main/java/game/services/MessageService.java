package game.services;

import game.controllers.dto.MessageDto;
import game.controllers.dto.UserDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getListOfMessages();
    void sendMessage(String text, UserDto user, int maxMessage);
    List<MessageDto> getRoomMessages(UserDto user);
}
