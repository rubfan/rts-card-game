package game.controllers.dto;

import java.util.List;

public class BuildingProductDto {

    private Integer id;
    private BuildingDto buildingDto;
    private List<ProductDto> productDtoList;

    public BuildingProductDto() {
    }

    public BuildingProductDto(Integer id, BuildingDto buildingDto, List<ProductDto> productDtoList) {
        this.id = id;
        this.buildingDto = buildingDto;
        this.productDtoList = productDtoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", buildingDto=" + buildingDto +
                ", productDtoList=" + productDtoList +
                '}';
    }
}
