package game.repositories.entities;

public class UpgradeQuantityEntity extends UpgradeEntity {
    private Float quantity;

    public UpgradeQuantityEntity(){}

    public UpgradeQuantityEntity(Integer id, String name, String description, Float quantity) {
        super(id, name, description);
        this.quantity = quantity;
    }

    public UpgradeQuantityEntity(Float quantity) {
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
        return "UpgradeQuantityEntity{" +
                "quantity=" + quantity +
                '}';
    }
}
