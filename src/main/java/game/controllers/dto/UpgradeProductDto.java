package game.controllers.dto;

import java.util.List;

public class UpgradeProductDto {
    private Integer id;
    private UpgradeDto upgradeDto;
    private List<ResourceQuantityDto> resourceQuantityDtoList;
    private List<BuildingDto> buildingDtoList;

    public UpgradeProductDto(Integer id, UpgradeDto upgradeDto, List<ResourceQuantityDto> resourceQuantityDtoList, List<BuildingDto> buildingDtoList) {
        this.id = id;
        this.upgradeDto = upgradeDto;
        this.resourceQuantityDtoList = resourceQuantityDtoList;
        this.buildingDtoList = buildingDtoList;
    }

    public UpgradeProductDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UpgradeDto getUpgradeDto() {
        return upgradeDto;
    }

    public void setUpgradeDto(UpgradeDto upgradeDto) {
        this.upgradeDto = upgradeDto;
    }

    public List<ResourceQuantityDto> getResourceQuantityDtoList() {
        return resourceQuantityDtoList;
    }

    public void setResourceQuantityDtoList(List<ResourceQuantityDto> resourceQuantityDtoList) {
        this.resourceQuantityDtoList = resourceQuantityDtoList;
    }

    public List<BuildingDto> getBuildingDtoList() {
        return buildingDtoList;
    }

    public void setBuildingDtoList(List<BuildingDto> buildingDtoList) {
        this.buildingDtoList = buildingDtoList;
    }

    @Override
    public String toString() {
        return "UpgradeProductDto{" +
                "id=" + id +
                ", upgradeDto=" + upgradeDto +
                ", resourceDtoList=" + resourceQuantityDtoList +
                ", buildingDtoList=" + buildingDtoList +
                '}';
    }
}
