package game.repositories.entities;

import java.util.List;

public class BuildingProductEntity {

    private BuildingEntity buildingEntity;
    private List<ProductEntity> productEntityList;

    public BuildingProductEntity() {
    }

    public BuildingProductEntity(BuildingEntity buildingEntity, List<ProductEntity> productEntityList) {
        this.buildingEntity = buildingEntity;
        this.productEntityList = productEntityList;
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
                "buildingEntity=" + buildingEntity +
                ", productEntityList=" + productEntityList +
                '}';
    }
}
