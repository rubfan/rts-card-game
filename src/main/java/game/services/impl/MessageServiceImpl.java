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
    public AccountService accountService;

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
        message.setFromAccountId(accountService.getAccountByUser(user).getId());
        if((accountService.getAccountByUser(user).getId()) == (accountService.getAccountByUser(user).getRoom().getAccount1().getId())){
            message.setToAccountId(accountService.getAccountByUser(user).getRoom().getAccount2().getId());
        }else {
            message.setToAccountId(accountService.getAccountByUser(user).getRoom().getAccount1().getId());
        }
        message.setTime(new Date());
        messageDao.sendMessage(message.getText(), message.getFromAccountId(), message.getToAccountId(), message.getTime().toString());
        messageDao.removeAboveLimit(maxMessages, accountService.getAccountByUser(user).getId());
    }

    @Override
    public List<MessageDto> getMessages(UserDto user) {
        MessageDto message = new MessageDto();
        message.setFromAccountId(accountService.getAccountByUser(user).getId());
        if((accountService.getAccountByUser(user).getId()) == (accountService.getAccountByUser(user).getRoom().getAccount1().getId())){
            message.setToAccountId(accountService.getAccountByUser(user).getRoom().getAccount2().getId());
        }else {
            message.setToAccountId(accountService.getAccountByUser(user).getRoom().getAccount1().getId());
        }

        final List<MessageDto> messages = new LinkedList<>();
        messageDao.getMessages(message.getFromAccountId(), message.getToAccountId()).forEach(messageEntity -> {
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
