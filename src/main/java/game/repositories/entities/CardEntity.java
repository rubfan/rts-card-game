package game.repositories.entities;

public class CardEntity {
    private int id;
    private String name;
    private String description;

    public CardEntity(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    private CardEntity(){
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
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
        return "CardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
