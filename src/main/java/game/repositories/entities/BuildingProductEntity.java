package game.repositories.entities;

import java.util.List;

public class BuildingProductEntity {

    private Integer id;
    private BuildingEntity buildingEntity;
    private List<ProductEntity> productEntityList;

    public BuildingProductEntity() {
    }

    public BuildingProductEntity(Integer id, BuildingEntity buildingEntity, List<ProductEntity> productEntityList) {
        this.id = id;
        this.buildingEntity = buildingEntity;
        this.productEntityList = productEntityList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BuildingEntity getBuildingEntity() {
        return buildingEntity;
    }

    public void setBuildingEntity(BuildingEntity buildingEntity) {
        this.buildingEntity = buildingEntity;
    }

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

    @Override
    public String toString() {
        return "BuildingProductEntity{" +
                "id=" + id +
                ", buildingEntity=" + buildingEntity +
                ", productEntityList=" + productEntityList +
                '}';
    }
}
