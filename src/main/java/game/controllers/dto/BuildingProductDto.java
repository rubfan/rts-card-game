package game.controllers.dto;

public class BuildingProductDto {
    private int buildingId;
    private int resourceId;
    private float numberPerSec;

    public BuildingProductDto() {
    }

    public BuildingProductDto(int buildingId, int resourceId, float numberPerSec) {
        this.buildingId = buildingId;
        this.resourceId = resourceId;
        this.numberPerSec = numberPerSec;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public float getNumberPerSec() {
        return numberPerSec;
    }

    public void setNumberPerSec(float numberPerSec) {
        this.numberPerSec = numberPerSec;
    }

    @Override
    public String toString() {
        return "BuildingProductDto{" +
                "buildingId=" + buildingId +
                ", resourceId=" + resourceId +
                ", numberPerSec=" + numberPerSec +
                '}';
    }
}
