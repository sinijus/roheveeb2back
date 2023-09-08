package ee.valiit.roheveeb2back.business;

import ee.valiit.roheveeb2back.domain.product.Product;
import ee.valiit.roheveeb2back.domain.product.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    public void findAllProducts() {
        List<Product> products = productService.getProducts();

    }
}
