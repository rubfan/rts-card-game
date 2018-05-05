package game.controllers.impl;

import game.controllers.ProductController;
import game.controllers.dto.ProductDto;
import game.services.ProductService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/product")
public class ProductControllerImpl implements ProductController {

    @Inject
    ProductService productService;
    @GET
    @Path("/{buildingId}/list/")
    @Override
    public List<ProductDto> getProductListByBuildingId(@PathParam("buildingId") Integer buildingId) {
        List<ProductDto> productDtoList = productService.getListOfProductByBuildingId(buildingId);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, productDtoList.toString());
        return productDtoList;
    }
}
