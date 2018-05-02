package game.repositories.entities;

public class ResourceQuantityEntity extends ResourceEntity {

    private Float quantity;

    public ResourceQuantityEntity(){}

    public ResourceQuantityEntity(Float quantity) {
        this.quantity = quantity;
    }

    public ResourceQuantityEntity(Integer id, String name, String description, Float quantity) {
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
        return "ResourceQuantityEntity{" +
                "quantity=" + quantity +
                '}';
    }
}
