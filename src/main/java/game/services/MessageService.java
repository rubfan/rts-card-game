package game.services;

import game.controllers.dto.AccountDto;
import game.controllers.dto.MessageDto;
import game.controllers.dto.RoomDto;
import game.controllers.dto.UserDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getListOfMessages();
    void sendMessage(MessageDto message, RoomDto room);
}
