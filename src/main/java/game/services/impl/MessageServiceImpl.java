package game.services.impl;

import game.controllers.dto.MessageDto;
import game.controllers.dto.RoomDto;
import game.repositories.dao.MessageDao;
import game.services.MessageService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    @Inject
    public MessageDao messageDao;

    public List<MessageDto> getListOfMessages() {
        final List<MessageDto> messages = new LinkedList<>();
        messageDao.getListOfMessages().forEach(messageEntity -> {
            messages.add(new MessageDto(){{
                setId(messageEntity.getId());
                setText(messageEntity.getText());
                if(messageEntity.getFrom_account_id() != null) {
                    setFrom_account_id(messageEntity.getFrom_account_id());
                }
                if(messageEntity.getTo_account_id() != null) {
                    setTo_account_id(messageEntity.getTo_account_id());
                }
                setTime(messageEntity.getTime());
            }});
        });
        return messages;
    }

    @Override
    public void sendMessage(MessageDto message, RoomDto room) {

    }
}
