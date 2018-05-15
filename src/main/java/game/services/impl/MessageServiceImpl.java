package game.services.impl;

import game.controllers.dto.MessageDto;
import game.controllers.dto.UserDto;
import game.repositories.dao.MessageDao;
import game.services.AccountService;
import game.services.MessageService;

import javax.inject.Inject;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    @Inject
    public MessageDao messageDao;
    @Inject
    public AccountService accountDao;

    public List<MessageDto> getListOfMessages() {
        final List<MessageDto> messages = new LinkedList<>();
        messageDao.getListOfMessages().forEach(messageEntity -> {
            messages.add(new MessageDto(){{
                setId(messageEntity.getId());
                setText(messageEntity.getText());
                if(messageEntity.getFromAccountId() != null) {
                    setFromAccountId(messageEntity.getFromAccountId());
                }
                if(messageEntity.getToAccountId() != null) {
                    setToAccountId(messageEntity.getToAccountId());
                }
                setTime(messageEntity.getTime());
            }});
        });
        return messages;
    }

    @Override
    public void sendMessage(String text, UserDto user, int maxMessages) {
        MessageDto message = new MessageDto();
        message.setText(text);
        message.setFromAccountId(accountDao.getAccountByUser(user).getId());
        if((accountDao.getAccountByUser(user).getId()) == (accountDao.getAccountByUser(user).getRoom().getAccount1().getId())){
            message.setToAccountId(accountDao.getAccountByUser(user).getRoom().getAccount2().getId());
        }else {
            message.setToAccountId(accountDao.getAccountByUser(user).getRoom().getAccount1().getId());
        }
        message.setTime(new Date());
        messageDao.sendMessage(message.getText(), message.getFromAccountId(), message.getToAccountId());
        messageDao.removeAboveLimit(maxMessages, accountDao.getAccountByUser(user).getId());
    }

    @Override
    public List<MessageDto> getRoomMessages(UserDto user) {
        MessageDto message = new MessageDto();
        message.setFromAccountId(accountDao.getAccountByUser(user).getId());
        if((accountDao.getAccountByUser(user).getId()) == (accountDao.getAccountByUser(user).getRoom().getAccount1().getId())){
            message.setToAccountId(accountDao.getAccountByUser(user).getRoom().getAccount2().getId());
        }else {
            message.setToAccountId(accountDao.getAccountByUser(user).getRoom().getAccount1().getId());
        }

        final List<MessageDto> messages = new LinkedList<>();
        messageDao.getRoomMessages(message.getFromAccountId(), message.getToAccountId()).forEach(messageEntity -> {
            messages.add(new MessageDto(){{
                setId(messageEntity.getId());
                setText(messageEntity.getText());
                if(messageEntity.getFromAccountId() != null) {
                    setFromAccountId(messageEntity.getFromAccountId());
                }
                if(messageEntity.getToAccountId() != null) {
                    setToAccountId(messageEntity.getToAccountId());
                }
                setTime(messageEntity.getTime());
            }});
        });
        return messages;
    }
}
