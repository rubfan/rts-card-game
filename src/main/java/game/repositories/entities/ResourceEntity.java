package game.repositories.entities;

public class ResourceEntity {
    private Integer id;
<<<<<<< HEAD:src/main/java/game/repositories/entities/ResourcesEntity.java
<<<<<<< HEAD
    private Integer number;
=======
//    private Integer number;
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
=======
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/repositories/entities/ResourceEntity.java
    private String name;
    private String description;

    public ResourceEntity() {}

<<<<<<< HEAD:src/main/java/game/repositories/entities/ResourcesEntity.java
    public ResourcesEntity() {
    }

<<<<<<< HEAD
    public ResourcesEntity(Integer id, Integer number, String name, String description) {
        this.id = id;
        this.number = number;
=======
    public ResourcesEntity(Integer id,/* Integer number,*/ String name, String description) {
        this.id = id;
//        this.number = number;
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
=======
    public ResourceEntity(Integer id, String name, String description) {
        this.id = id;
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/repositories/entities/ResourceEntity.java
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

<<<<<<< HEAD:src/main/java/game/repositories/entities/ResourcesEntity.java
<<<<<<< HEAD
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
=======
//    public Integer getNumber() {
//        return number;
//    }
//
//    public void setNumber(Integer number) {
//        this.number = number;
//    }
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047

=======
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/repositories/entities/ResourceEntity.java
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

    @Override
    public String toString() {
        return "ResourceEntity{" +
                "id=" + id +
<<<<<<< HEAD:src/main/java/game/repositories/entities/ResourcesEntity.java
<<<<<<< HEAD
                ", number=" + number +
=======
//                ", number=" + number +
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
=======
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/repositories/entities/ResourceEntity.java
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
