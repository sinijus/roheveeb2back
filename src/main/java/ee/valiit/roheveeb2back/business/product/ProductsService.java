package ee.valiit.roheveeb2back.business.product;

import ee.valiit.roheveeb2back.business.dto.CategoryDto;
import ee.valiit.roheveeb2back.business.dto.ProductInfoDto;
import ee.valiit.roheveeb2back.business.dto.TypeDto;
import ee.valiit.roheveeb2back.domain.measureunit.MeasureUnit;
import ee.valiit.roheveeb2back.domain.company.Company;
import ee.valiit.roheveeb2back.domain.company.CompanyMapper;
import ee.valiit.roheveeb2back.domain.image.Image;
import ee.valiit.roheveeb2back.business.dto.MeasureUnitDto;
import ee.valiit.roheveeb2back.domain.measureunit.MeasureUnitMapper;
import ee.valiit.roheveeb2back.domain.measureunit.MeasureUnitService;
import ee.valiit.roheveeb2back.domain.type.Type;
import ee.valiit.roheveeb2back.domain.type.TypeMapper;
import ee.valiit.roheveeb2back.domain.type.TypeService;
import ee.valiit.roheveeb2back.domain.category.Category;
import ee.valiit.roheveeb2back.domain.category.CategoryMapper;
import ee.valiit.roheveeb2back.domain.category.CategoryService;
import ee.valiit.roheveeb2back.business.dto.ProductDto;
import ee.valiit.roheveeb2back.domain.image.ImageService;
import ee.valiit.roheveeb2back.domain.product.Product;
import ee.valiit.roheveeb2back.domain.product.ProductMapper;
import ee.valiit.roheveeb2back.domain.product.ProductService;
import ee.valiit.roheveeb2back.util.ImageConverter;
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
    private TypeService typeService;
    @Resource
    private ImageService imageService;

    @Resource
    private CompanyService companyService;

    @Resource
    private MeasureUnitService measureUnitService;
    @Resource
    private ProductMapper productMapper;

    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private TypeMapper typeMapper;

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    private MeasureUnitMapper measureUnitMapper;


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

    public List<TypeDto> findAllTypes() {
        List<Type> types = typeService.findAllTypes();
        List<TypeDto> typeDtos = typeMapper.toTypeDtos(types);
        return typeDtos;
    }

    @Transactional
    public void addNewProduct(ProductDto request) {
        productService.confirmProductNameAvailability(request.getProductName());
        Product product = productMapper.toProduct(request);
        if (request.getImageData() != null) {
            Image image = ImageConverter.imageDataToImage(request.getImageData());
            imageService.saveImage(image);
            product.setImage(image);
        }
        Company company = companyService.getCompanyBy(request.getCompanyId());
        product.setCompany(company);
        MeasureUnit measureUnit = measureUnitService.getMeasureUnitBy(request.getMeasureUnitId());
        product.setMeasureUnit(measureUnit);
        Type type = typeService.getTypeBy(request.getTypeId());
        product.setType(type);
        productService.saveProduct(product);
    }

    public List<MeasureUnitDto> getMeasureUnits() {
        List<MeasureUnit> measureUnits = measureUnitService.getMeasureUnits();
        return measureUnitMapper.toMeasureUnits(measureUnits);
    }
}
