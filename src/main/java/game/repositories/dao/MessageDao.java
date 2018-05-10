package game.repositories.dao;

import game.repositories.entities.MessageEntity;

import java.util.List;

public interface MessageDao {
    List<MessageEntity> getListOfMessages();
    void sendMessage(String text, Integer from_account_id, Integer to_account_id);
    void getMessage();
}
