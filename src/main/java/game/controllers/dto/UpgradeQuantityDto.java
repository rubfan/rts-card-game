package game.controllers.dto;

public class UpgradeQuantityDto extends UpgradeDto {
    private Float quantity;

    public UpgradeQuantityDto(){}

    public UpgradeQuantityDto(Float quantity) {
        this.quantity = quantity;
    }

    public UpgradeQuantityDto(Integer id, String name, String description, Float quantity) {
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
        return "UpgradeQuantityDto{" +
                "quantity=" + quantity +
                '}';
    }
}
