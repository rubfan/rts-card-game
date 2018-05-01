package game.repositories.dao.impl;

import config.DeployDbConfig;
import game.repositories.dao.MessageDao;
import game.repositories.entities.MessageEntity;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MessageDaoImplTest {

    @Before
    public void init(){
        DeployDbConfig deployDB = new DeployDbConfig();
    }

    @Test
    public void getListOfMessage() {
        MessageDao messageDao = new MessageDaoImpl();
        List<MessageEntity> mdto = messageDao.getListOfMessages();

        for (MessageEntity message : mdto){
            System.out.println(message);
        }
        assertTrue(mdto.size() > 0);
    }
}
