package game.repositories.entities;

import java.util.Date;

/**
 * @author ruslangramatic on 4/16/18.
 */
public class RoomEntity {
    private Integer id;
    private String name;
    private String description;
    private AccountEntity account1;
    private AccountEntity account2;
    private Date start_game_time;

    public RoomEntity(Integer id, String name, String description, AccountEntity account1, AccountEntity account2,Date start_game_time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.account1 = account1;
        this.account2 = account2;
        this.start_game_time=start_game_time;
    }

    public RoomEntity() {}

    public AccountEntity getAccount1() {
        return account1;
    }

    public void setAccount1(AccountEntity account1) {
        this.account1 = account1;
    }

    public AccountEntity getAccount2() {
        return account2;
    }

    public void setAccount2(AccountEntity account2) {
        this.account2 = account2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
               " account1:"+getAccount1()+
               " account2:"+getAccount2()+
                "start_game_time:"+getStart_game_time();
    }
}
