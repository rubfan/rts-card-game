package game.repositories.entities;

public class ProductEntity extends ResourceEntity {

    private Integer numPerSec;

    public ProductEntity() {
    }

    public ProductEntity(Integer id, String name, String description, Integer numPerSec) {
        super(id, name, description);
        this.numPerSec = numPerSec;
    }

    public Integer getNumPerSec() {
        return numPerSec;
    }

    public void setNumPerSec(Integer numPerSec) {
        this.numPerSec = numPerSec;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "numPerSec=" + numPerSec +
                "} " + super.toString();
    }
}
