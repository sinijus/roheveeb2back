package ee.valiit.roheveeb2back.business;

import ee.valiit.roheveeb2back.domain.product.Product;
import ee.valiit.roheveeb2back.domain.product.ProductMapper;
import ee.valiit.roheveeb2back.domain.product.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;

    public List<ProductInfoDto> findAllProducts() {
        List<Product> products = productService.findAllProducts();
        List<ProductInfoDto> productInfoDtos = productMapper.toProductInfoDtos(products);
        return productInfoDtos;

    }

    public List<ProductInfoDto> getCategories(Integer categoryId, String categoryName) {
        List<Product> categories = productService.getCategories(categoryId, categoryName);
        List<ProductInfoDto> productInfoDtos = productMapper.toProductInfoDtos(categories);
        return productInfoDtos;
    }
}
