package game.repositories.dao;

import game.repositories.entities.MessageEntity;

import java.util.Date;
import java.util.List;

public interface MessageDao {
    List<MessageEntity> getListOfMessages();
    void sendMessage(String text, int fromAccountId, int toAccountId);
    List<MessageEntity> getRoomMessages(int fromAccountId, int toAccountId);
    void removeAboveLimit(int maxMessages, int fromAccountId);
}
