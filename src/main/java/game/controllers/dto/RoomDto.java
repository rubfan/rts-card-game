package game.controllers.dto;

import java.util.Date;

/**
 * @author ruslangramatic on 4/16/18.
 */
public class RoomDto {
    private Integer id;
    private String name;
    private String description;
    private AccountDto account1;
    private AccountDto account2;
    private Date start_game_time;

    public RoomDto() {}

    public RoomDto(Integer id, String name, String description, AccountDto account1, AccountDto account2) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.account1 = account1;
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

    public AccountDto getAccount1() {
        return account1;
    }

    public void setAccount1(AccountDto account1) {
        this.account1 = account1;
    }

    public AccountDto getAccount2() {
        return account2;
    }

    public void setAccount2(AccountDto account2) {
        this.account2 = account2;
    }

    public Date getSetStart_game_time() {
        return start_game_time;
    }

    public void setSetStart_game_time(Date setStart_game_time) {
        this.start_game_time = setStart_game_time;
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", account1=" + account1 +
                ", account2=" + account2 +
                ", setStart_game_time=" + start_game_time +
                '}';
    }
}
