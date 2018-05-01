package game.controllers.dto;

import java.util.Date;

public class AccountDto {

    private Integer id;
    private Integer user_id;
    private Integer room_id;


    private Date start_game_time;

    public AccountDto() {
    }

    public AccountDto(Integer id, Integer user_id, Integer room_id, Date start_game_time) {
        this.id = id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.start_game_time=start_game_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
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
                ", user_id=" + user_id +
                ", room_id=" + room_id +
                ",start_game_time+"+getStart_game_time() +
                '}';
    }
}
