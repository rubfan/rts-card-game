package game.controllers.dto;

import java.util.Date;

public class AccountDto {

    private Integer id;
    private UserDto user;
    private RoomDto room;

    private Date start_game_time;

    public AccountDto() {}

    public AccountDto(Integer id, UserDto user, RoomDto room, Date start_game_time) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.start_game_time = start_game_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }

    public Date getStart_game_time() {
        return start_game_time;
    }

    public void setStart_game_time(Date start_game_time) {
        this.start_game_time = start_game_time;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                ",start_game_time+"+getStart_game_time() +
                '}';
    }
}
