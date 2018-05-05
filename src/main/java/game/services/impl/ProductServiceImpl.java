package game.services.impl;

import game.controllers.dto.ProductDto;
import game.repositories.dao.ProductDao;
import game.services.ProductService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Inject
    ProductDao productDao;

    @Override
    public List<ProductDto> getListOfProductByBuildingId(Integer buildingId) {
        final List<ProductDto> productDtoList = new LinkedList<>();
        productDao.getListOfProductByBuldingId(buildingId).forEach(
                productEntity -> {
                    productDtoList.add(new ProductDto() {{
                        setId(productEntity.getId());
                        setResourceEntity(productEntity.getResourceEntity());
                        setNumberPerSec(productEntity.getNumberPerSec());
                    }});
                }
        );
        return productDtoList;
    }
}
