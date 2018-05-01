package game.controllers.dto;

public class UpgradeDto {
    private Integer id;
    private String name;
    private String description;

    public UpgradeDto(){}

    public UpgradeDto(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "UpgradeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
