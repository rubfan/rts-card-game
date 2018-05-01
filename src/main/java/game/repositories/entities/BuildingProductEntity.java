package game.repositories.entities;

public class BuildingProductEntity {

    private int buildingId;
    private int resourceId;
    private float numberPerSec;

    public BuildingProductEntity(int buildingId, int resourceId, float numberPerSec) {
        this.buildingId = buildingId;
        this.resourceId = resourceId;
        this.numberPerSec = numberPerSec;
    }

    public BuildingProductEntity() {
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
        return "BuildingProductEntity{" +
                "buildingId=" + buildingId +
                ", resourceId=" + resourceId +
                ", numberPerSec=" + numberPerSec +
                '}';
    }
}
