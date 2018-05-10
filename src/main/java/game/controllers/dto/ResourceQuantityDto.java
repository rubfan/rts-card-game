package game.controllers.dto;

public class ResourceQuantityDto extends ResourceDto {

    private Float quantity;

    public ResourceQuantityDto(){}

    public ResourceQuantityDto(Float quantity) {
        this.quantity = quantity;
    }

    public ResourceQuantityDto(Integer id, String name, String description, Float quantity) {
        super(id, name, description);
        this.quantity = quantity;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ResourceQuantityDto{" +
                "quantity=" + quantity +
                '}';
    }
}
