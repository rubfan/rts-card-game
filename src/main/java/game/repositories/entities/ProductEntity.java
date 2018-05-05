package game.repositories.entities;

public class ProductEntity {
    private Integer id;
    private ResourceEntity resourceEntity;
    private Integer numberPerSec;

    public ProductEntity() {
    }

    public ProductEntity(Integer id, ResourceEntity resourceEntity, Integer mumberPerSec) {
        this.id = id;
        this.resourceEntity = resourceEntity;
        this.numberPerSec = mumberPerSec;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResourceEntity getResourceEntity() {
        return resourceEntity;
    }

    public void setResourceEntity(ResourceEntity resourceEntity) {
        this.resourceEntity = resourceEntity;
    }

    public Integer getNumberPerSec() {
        return numberPerSec;
    }

    public void setNumberPerSec(Integer numberPerSec) {
        this.numberPerSec = numberPerSec;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", resourceEntity=" + resourceEntity +
                ", numberPerSec=" + numberPerSec +
                '}';
    }
}
