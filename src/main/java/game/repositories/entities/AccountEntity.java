package game.repositories.entities;

public class AccountEntity {

    private Integer id;
    private UserEntity user;
    private RoomEntity room;

    public AccountEntity() {}

    public AccountEntity(Integer id, UserEntity user, RoomEntity room) {
        this.id = id;
        this.user = user;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                '}';
    }
}
