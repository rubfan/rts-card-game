package game.repositories.entities;

/**
 * @author ruslangramatic on 4/20/18.
 */
public class UserEntity {
    private Integer id;
    private String name;
    private String password;
    private String token;

    public UserEntity(Integer id, String name, String password, String token) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.token = token;
    }

    public UserEntity() {}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
