package ee.valiit.roheveeb2back.domain.product;

import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        List<Product> products = productRepository.findAllProductsBy(Status.ACTIVE.getLetter());
        ValidationService.validateAtLeastOneProductExists(products);
        return products;
    }


    public List<Product> getCategories(Integer categoryId, String categoryName) {
        List<Product> categories = productRepository.findAllCategoriesBy(categoryId, categoryName);
        return categories;
    }
}
