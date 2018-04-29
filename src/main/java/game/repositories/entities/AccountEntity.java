package game.repositories.entities;

public class AccountEntity {

    private int id;
    private int user_id;
    private int room_id;

    public AccountEntity() {
    }

    public AccountEntity(int id, int user_id, int room_id) {
        this.id = id;
        this.user_id = user_id;
        this.room_id = room_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
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
