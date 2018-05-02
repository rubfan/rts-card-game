package game.controllers.dto;

public class ResourсeDto {
    private Integer id;
<<<<<<< HEAD:src/main/java/game/controllers/dto/ResourсesDto.java
<<<<<<< HEAD
    private Integer number;
=======
    //private Integer number;
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
=======
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/controllers/dto/ResourсeDto.java
    private String name;
    private String description;


    public ResourсeDto() {}

<<<<<<< HEAD:src/main/java/game/controllers/dto/ResourсesDto.java
<<<<<<< HEAD
    public ResourсesDto(Integer id, Integer number, String name, String description) {
        this.id = id;
        this.number = number;
=======
    public ResourсesDto(Integer id,/* Integer number,*/ String name, String description) {
        this.id = id;
      //  this.number = number;
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
=======
    public ResourсeDto(Integer id, String name, String description) {
        this.id = id;
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/controllers/dto/ResourсeDto.java
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

<<<<<<< HEAD:src/main/java/game/controllers/dto/ResourсesDto.java
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
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/controllers/dto/ResourсeDto.java
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
        return "ResourсeDto{" +
                "id=" + id +
<<<<<<< HEAD:src/main/java/game/controllers/dto/ResourсesDto.java
<<<<<<< HEAD
                ", number=" + number +
=======
//                ", number=" + number +
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
=======
>>>>>>> 07b3999f3ebe14f462141f2d600db736f993e516:src/main/java/game/controllers/dto/ResourсeDto.java
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
