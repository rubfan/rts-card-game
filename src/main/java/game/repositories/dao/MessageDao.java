package game.repositories.dao;

import game.repositories.entities.MessageEntity;

import java.util.List;

public interface MessageDao {
    List<MessageEntity> getListOfMessages();
}
