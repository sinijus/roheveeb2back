package ee.valiit.roheveeb2back.business;

import ee.valiit.roheveeb2back.domain.category.Category;
import ee.valiit.roheveeb2back.domain.category.CategoryMapper;
import ee.valiit.roheveeb2back.domain.category.CategoryService;
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
    private CategoryService categoryService;


    @Resource
    private ImageService imageService;

    @Resource
    private ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Resource
    private CategoryMapper categoryMapper;

    public List<ProductInfoDto> findAllProducts() {
        List<Product> products = productService.findAllProducts();
        List<ProductInfoDto> productInfoDtos = productMapper.toProductInfoDtos(products);
        return productInfoDtos;

    }

    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryService.getCategories();
        List<CategoryDto> categoryDtos = categoryMapper.toCategoryDtos(categories);
        return categoryDtos;


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
