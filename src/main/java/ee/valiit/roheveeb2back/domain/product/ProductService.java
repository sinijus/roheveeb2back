package ee.valiit.roheveeb2back.domain.product;

import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        List<Product> products = productRepository.findAllProductsBy(Status.ACTIVE.getLetter());
        ValidationService.validateAtLeastOneProductExists(products);
        return products;
    }


    public void confirmProductNameAvailability(String productName) {
        boolean productExists = productRepository.productExistsBy(productName, Status.ACTIVE.getLetter());
        ValidationService.validateProductNameIsAvailable(productExists);

    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductBy(Integer productId) {
        return productRepository.findById(productId).get();
    }


    public List<Product> findProductByCompanyId(Integer companyId) {
        return productRepository.findProductsByCompanyId(companyId);

    }

    public Product getProductsBy(Integer productId) {
        return productRepository.findById(productId).get();
    }
}
