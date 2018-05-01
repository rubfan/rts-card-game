package game.repositories.entities;

import java.util.List;

public class UpgradeProductEntity {
    private Integer id;
    private UpgradeEntity upgradeEntity;
    private List<ResourceEntity> resourceEntityList;
    private List<BuildingEntity> buildingEntities;

    public UpgradeProductEntity(Integer id, UpgradeEntity upgradeEntity, List<ResourceEntity> resourceEntityList, List<BuildingEntity> buildingEntities) {
        this.id = id;
        this.upgradeEntity = upgradeEntity;
        this.resourceEntityList = resourceEntityList;
        this.buildingEntities = buildingEntities;
    }

    UpgradeProductEntity(){}

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

    public List<ResourceEntity> getResourceEntityList() {
        return resourceEntityList;
    }

    public void setResourceEntityList(List<ResourceEntity> resourceEntityList) {
        this.resourceEntityList = resourceEntityList;
    }

    public List<BuildingEntity> getBuildingEntities() {
        return buildingEntities;
    }

    public void setBuildingEntities(List<BuildingEntity> buildingEntities) {
        this.buildingEntities = buildingEntities;
    }

    @Override
    public String toString() {
        return "UpgradeProductEntity{" +
                "id=" + id +
                ", upgradeEntity=" + upgradeEntity +
                ", resourceEntityList=" + resourceEntityList +
                ", buildingEntities=" + buildingEntities +
                '}';
    }
}
