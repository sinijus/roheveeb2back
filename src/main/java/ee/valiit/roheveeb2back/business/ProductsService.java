package ee.valiit.roheveeb2back.business;

import ee.valiit.roheveeb2back.business.dto.ProductDto;
import ee.valiit.roheveeb2back.business.dto.ProductInfoDto;
import ee.valiit.roheveeb2back.domain.image.ImageService;
import ee.valiit.roheveeb2back.domain.product.Product;
import ee.valiit.roheveeb2back.domain.product.ProductMapper;
import ee.valiit.roheveeb2back.domain.product.ProductRepository;
import ee.valiit.roheveeb2back.domain.product.ProductService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private ImageService imageService;

    @Resource
    private ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductInfoDto> findAllProducts() {
        List<Product> products = productService.findAllProducts();
        List<ProductInfoDto> productInfoDtos = productMapper.toProductInfoDtos(products);
        return productInfoDtos;

    }

    @Transactional
    public void addNewProduct(ProductDto request) {
        productService.confirmProductNameAvailability(request.getProductName());
        Product product = productMapper.toProduct(request);
//        Image image = ImageConverter.imageDataToImage(request.getProductImageData());
//        imageService.saveImage(image);
//        product.setImage(image);
        productService.saveProduct(product);

    }
}
