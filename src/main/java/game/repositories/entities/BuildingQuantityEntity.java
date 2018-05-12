package game.repositories.entities;

public class BuildingQuantityEntity extends BuildingEntity {
    private Float quantity;

    public BuildingQuantityEntity(){}

    public BuildingQuantityEntity(Float quantity) {
        this.quantity = quantity;
    }

    public BuildingQuantityEntity(Integer id, String name, String description, Float quantity) {
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
        return "BuildingQuantityEntity{" +
                "quantity=" + quantity +
                '}';
    }
}
