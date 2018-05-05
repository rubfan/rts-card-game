package game.controllers.dto;

import game.repositories.entities.ResourceEntity;

public class ProductDto {
    private Integer id;
    private ResourceEntity resourceEntity;
    private Integer mumberPerSec;

    public ProductDto() {
    }

    public ProductDto(Integer id, ResourceEntity resourceEntity, Integer mumberPerSec) {
        this.id = id;
        this.resourceEntity = resourceEntity;
        this.mumberPerSec = mumberPerSec;
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

    public Integer getMumberPerSec() {
        return mumberPerSec;
    }

    public void setNumberPerSec(Integer mumberPerSec) {
        this.mumberPerSec = mumberPerSec;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", resourceEntity=" + resourceEntity +
                ", mumberPerSec=" + mumberPerSec +
                '}';
    }
}
