package ee.valiit.roheveeb2back.domain.product;

import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.infrastructure.exception.DataNotFoundException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.zip.DataFormatException;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        List<Product> products = productRepository.findAllProductsBy(Status.ACTIVE.name());
        // todo: Validation service
        if (products.isEmpty()) {
//            throw new DataNotFoundException();
        }
        return products;
    }


}
