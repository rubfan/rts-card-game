package game.repositories.entities;

public class AccountEntity {

    private Integer id;
    private Integer user_id;
    private Integer room_id;

    public AccountEntity() {
    }

    public AccountEntity(Integer id, Integer user_id, Integer room_id) {
        this.id = id;
        this.user_id = user_id;
        this.room_id = room_id;
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


    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", room_id=" + room_id +
                '}';
    }
}
