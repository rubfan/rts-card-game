package game.controllers;

import game.controllers.dto.RoomDto;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author ruslangramatic on 4/20/18.
 */
public interface RoomController {
    List<RoomDto> getRoomList();
    Response joinRoom(String roomId, String token);
    Response exitRoom(String roomId, String token);
}
