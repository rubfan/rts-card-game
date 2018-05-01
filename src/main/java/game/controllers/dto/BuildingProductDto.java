package game.controllers.dto;

public class BuildingProductDto {
    private Integer buildingId;
    private Integer resourceId;
    private Float numberPerSec;

    public BuildingProductDto() {
    }

    public BuildingProductDto(Integer buildingId, Integer resourceId, Float numberPerSec) {
        this.buildingId = buildingId;
        this.resourceId = resourceId;
        this.numberPerSec = numberPerSec;
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
        return "BuildingProductDto{" +
                "buildingId=" + buildingId +
                ", resourceId=" + resourceId +
                ", numberPerSec=" + numberPerSec +
                '}';
    }
}
