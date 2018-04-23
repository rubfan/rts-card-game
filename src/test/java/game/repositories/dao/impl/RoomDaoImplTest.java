package game.repositories.dao.impl;

import config.DeployDbConfig;
import game.repositories.dao.RoomDao;

import game.repositories.entities.RoomEntity;
import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by ruslangramatic on 4/19/18.
 */
public class RoomDaoImplTest {

    @Before
    public void init(){
        DeployDbConfig deployDB = new DeployDbConfig();
    }

    @Test
    public void getListOfRooms() {
        RoomDao roomDao = new RoomDaoImpl();
        List<RoomEntity> rdto = roomDao.getListOfRooms();

        for (RoomEntity room : rdto){
            System.out.println(room);
        }
        assertTrue(rdto.size() > 0);
    }
}