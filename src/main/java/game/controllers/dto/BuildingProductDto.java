package game.controllers.dto;

import java.util.List;

public class BuildingProductDto {

    private BuildingDto buildingDto;
    private List<ProductDto> productDtoList;

    public BuildingProductDto() {
    }

    public BuildingProductDto(BuildingDto buildingDto, List<ProductDto> productDtoList) {
        this.buildingDto = buildingDto;
        this.productDtoList = productDtoList;
    }

    public BuildingDto getBuildingDto() {
        return buildingDto;
    }

    public void setBuildingDto(BuildingDto buildingDto) {
        this.buildingDto = buildingDto;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }

    @Override
    public String toString() {
        return "BuildingProductDto{" +
                "buildingDto=" + buildingDto +
                ", productDtoList=" + productDtoList +
                '}';
    }
}
