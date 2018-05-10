package game.controllers.dto;

import game.repositories.entities.BuildingQuantityEntity;

public class BuildingQuantityDto extends BuildingDto {
    private Float quantity;

    public BuildingQuantityDto(){}

    public BuildingQuantityDto(Float quantity) {
        this.quantity = quantity;
    }

    public BuildingQuantityDto(Integer id, String name, String description, Float quantity) {
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
        return "BuildingQuantityDto{" +
                "quantity=" + quantity +
                '}';
    }
}
