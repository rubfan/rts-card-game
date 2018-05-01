package game.controllers.dto;

/**
 * @author ruslangramatic on 4/16/18.
 */
public class RoomDto {
    private Integer id;
    private String name;
    private String description;
    private Integer account_1_id;
    private Integer account_2_id;

    public RoomDto() {
    }

    public RoomDto(Integer id, String name, String description, Integer account_1_id, Integer account_2_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.account_1_id = account_1_id;
        this.account_2_id = account_2_id;
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

    public Integer getAccount_1_id() {
        return account_1_id;
    }

    public void setAccount_1_id(Integer account_1_id) {
        this.account_1_id = account_1_id;
    }

    public Integer getAccount_2_id() {
        return account_2_id;
    }

    public void setAccount_2_id(Integer account_2_id) {
        this.account_2_id = account_2_id;
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", account_1_id=" + account_1_id +
                ", account_2_id=" + account_2_id +
                '}';
    }
}
