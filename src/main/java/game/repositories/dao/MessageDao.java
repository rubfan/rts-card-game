package game.repositories.dao;

import game.repositories.entities.MessageEntity;

import java.util.List;

public interface MessageDao {
    List<MessageEntity> getListOfMessages();
    void sendMessage(String text, int fromAccountId, int toAccountId, String time);
    List<MessageEntity> getMessages(int fromAccountId, int toAccountId);
    void removeAboveLimit(int maxMessages, int fromAccountId);
}
