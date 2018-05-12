package game.services.impl;

import game.controllers.dto.BuildingDto;
import game.controllers.dto.BuildingProductDto;
import game.controllers.dto.ProductDto;
import game.repositories.dao.BuildingProductDao;
import game.repositories.entities.BuildingProductEntity;
import game.services.BuildingProductService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class BuildingProductServiceImpl implements BuildingProductService {

    @Inject
    public BuildingProductDao buildingProductDao;

    @Override
    public List<BuildingProductDto> getListOfBuildingResources() {

            final List<BuildingProductDto> buildingProducts = new LinkedList<>();

            buildingProductDao.getListOfBuildingResources().forEach(buildingProductEntity -> {
                buildingProducts.add(new BuildingProductDto(){{
                    setId(buildingProductEntity.getId());
                    setBuildingDto(new BuildingDto(
                            buildingProductEntity.getBuildingEntity().getId(),
                            buildingProductEntity.getBuildingEntity().getName(),
                            buildingProductEntity.getBuildingEntity().getDescription())
                    );
                    setProductDtoList(getProductList(buildingProductEntity));
                }});
            });
            return buildingProducts;
    }

    private List<ProductDto> getProductList(BuildingProductEntity buildingProductEntity){

        final List<ProductDto> products = new LinkedList<>();

        buildingProductEntity.getProductEntityList().forEach(productEntity -> {

            products.add(new ProductDto(
                    productEntity.getId(),
                    productEntity.getName(),
                    productEntity.getDescription(),
                    productEntity.getNumPerSec()
            ));
        });

        return products;
    }
}
