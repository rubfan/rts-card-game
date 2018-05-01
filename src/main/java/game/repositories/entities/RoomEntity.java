package game.repositories.entities;

import java.util.Date;

/**
 * @author ruslangramatic on 4/16/18.
 */
public class RoomEntity {
    private int id;
    private String name;
    private String description;
    private int account_1_id;
    private int account_2_id;
    private Date start_game_time;

    public RoomEntity(int id, String name, String description, int account_1_id, int account_2_id,Date start_game_time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.account_1_id = account_1_id;
        this.account_2_id = account_2_id;
        this.start_game_time=start_game_time;
    }

    public RoomEntity() {}

    public int getAccount_1_id() {
        return account_1_id;
    }

    public void setAccount_1_id(int account_1_id) {
        this.account_1_id = account_1_id;
    }

    public int getAccount_2_id() {
        return account_2_id;
    }

    public void setAccount_2_id(int account_2_id) {
        this.account_2_id = account_2_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_game_time() {
        return start_game_time;
    }

    public void setStart_game_time(Date start_game_time) {
        this.start_game_time = start_game_time;
    }


    @Override
    public String toString() {
        return "id:"+getId()+
               " name:"+getName()+
               " description:"+getDescription()+
               " account_1_id:"+getAccount_1_id()+
               " account_2_id:"+getAccount_2_id()+
                "start_game_time:"+getStart_game_time();
    }
}
