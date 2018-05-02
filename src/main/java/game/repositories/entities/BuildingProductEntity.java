package game.repositories.entities;

public class BuildingProductEntity {

    private Integer buildingId;
    private Integer resourceId;
    private Float numberPerSec;

    public BuildingProductEntity(Integer buildingId, Integer resourceId, Float numberPerSec) {
        this.buildingId = buildingId;
        this.resourceId = resourceId;
        this.numberPerSec = numberPerSec;
    }

    public BuildingProductEntity() {
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Float getNumberPerSec() {
        return numberPerSec;
    }

    public void setNumberPerSec(Float numberPerSec) {
        this.numberPerSec = numberPerSec;
    }

    @Override
    public String toString() {
        return "BuildingProductEntity{" +
                "buildingId=" + buildingId +
                ", resourceId=" + resourceId +
                ", numberPerSec=" + numberPerSec +
                '}';
    }
}
