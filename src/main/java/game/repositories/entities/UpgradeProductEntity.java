package game.repositories.entities;

import java.util.List;

public class UpgradeProductEntity {
    private Integer id;
    private UpgradeEntity upgradeEntity;
    private List<ResourceQuantityEntity> resourceEntityList;
    private List<BuildingEntity> buildingEntityList;

    public UpgradeProductEntity(Integer id, UpgradeEntity upgradeEntity, List<ResourceQuantityEntity> resourceEntityList, List<BuildingEntity> buildingEntityList) {
        this.id = id;
        this.upgradeEntity = upgradeEntity;
        this.resourceEntityList = resourceEntityList;
        this.buildingEntityList = buildingEntityList;
    }

    public UpgradeProductEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UpgradeEntity getUpgradeEntity() {
        return upgradeEntity;
    }

    public void setUpgradeEntity(UpgradeEntity upgradeEntity) {
        this.upgradeEntity = upgradeEntity;
    }

    public List<ResourceQuantityEntity> getResourceEntityList() {
        return resourceEntityList;
    }

    public void setResourceEntityList(List<ResourceQuantityEntity> resourceEntityList) {
        this.resourceEntityList = resourceEntityList;
    }

    public List<BuildingEntity> getBuildingEntityList() {
        return buildingEntityList;
    }

    public void setBuildingEntityList(List<BuildingEntity> buildingEntityList) {
        this.buildingEntityList = buildingEntityList;
    }

    @Override
    public String toString() {
        return "UpgradeProductEntity{" +
                "id=" + id +
                ", upgradeEntity=" + upgradeEntity +
                ", resourceEntityList=" + resourceEntityList +
                ", buildingEntityList=" + buildingEntityList +
                '}';
    }
}
