package game.controllers.dto;

/**
 * @autor ruslangramatic on 4/20/18.
 */

public class UserDto {
    private int id;
    private String name;
    private String password;
    private int token;

    public UserDto() {}

    public UserDto(int id, String name, String password, int token) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.token = token;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", token=" + token +
                '}';
    }
}
