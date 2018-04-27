package game.controllers.dto;

public class ResourсesDto {
    private Integer id;
    private Integer number;
    private String name;
    private String discription;


    public ResourсesDto() {
    }

    public ResourсesDto(Integer id, Integer number, String name, String discription) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.discription = discription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
