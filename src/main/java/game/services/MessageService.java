package game.services;

import game.controllers.dto.MessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getListOfMessages();
}
