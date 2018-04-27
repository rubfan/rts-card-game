package game.controllers.dto;

public class ResourсesDto {
    private Integer id;
<<<<<<< HEAD
    private Integer number;
=======
    //private Integer number;
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
    private String name;
    private String description;


    public ResourсesDto() {
    }

<<<<<<< HEAD
    public ResourсesDto(Integer id, Integer number, String name, String description) {
        this.id = id;
        this.number = number;
=======
    public ResourсesDto(Integer id,/* Integer number,*/ String name, String description) {
        this.id = id;
      //  this.number = number;
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "ResourсesDto{" +
                "id=" + id +
<<<<<<< HEAD
                ", number=" + number +
=======
//                ", number=" + number +
>>>>>>> f51361c04eafcd0a0918362d237cfad9254d7047
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
