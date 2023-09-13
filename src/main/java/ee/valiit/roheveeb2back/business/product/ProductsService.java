package ee.valiit.roheveeb2back.business.product;

import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.business.dto.*;
import ee.valiit.roheveeb2back.domain.category.Category;
import ee.valiit.roheveeb2back.domain.category.CategoryMapper;
import ee.valiit.roheveeb2back.domain.category.CategoryService;
import ee.valiit.roheveeb2back.domain.company.Company;
import ee.valiit.roheveeb2back.domain.company.CompanyMapper;
import ee.valiit.roheveeb2back.domain.image.Image;
import ee.valiit.roheveeb2back.domain.image.ImageService;
import ee.valiit.roheveeb2back.domain.measureunit.MeasureUnit;
import ee.valiit.roheveeb2back.domain.measureunit.MeasureUnitMapper;
import ee.valiit.roheveeb2back.domain.measureunit.MeasureUnitService;
import ee.valiit.roheveeb2back.domain.product.Product;
import ee.valiit.roheveeb2back.domain.product.ProductMapper;
import ee.valiit.roheveeb2back.domain.product.ProductService;
import ee.valiit.roheveeb2back.domain.type.Type;
import ee.valiit.roheveeb2back.domain.type.TypeMapper;
import ee.valiit.roheveeb2back.domain.type.TypeService;
import ee.valiit.roheveeb2back.util.ImageConverter;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public void deleteProduct(Integer productId) {
        Product product = productService.getProductBy(productId);
        product.setStatus(Status.DELETED.getLetter());
        productService.saveProduct(product);
    }

    public List<MeasureUnitDto> getMeasureUnits() {
        List<MeasureUnit> measureUnits = measureUnitService.getMeasureUnits();
        return measureUnitMapper.toMeasureUnits(measureUnits);
    }

    @Transactional
    public void updateProductInfo(Integer productId, ProductDto request) {
        Product product = productService.getProductBy(productId);
        productMapper.partialUpdate(request, product);

        handleProductNameUpdate(request, product);
        handleMeasureUnitIdUpdate(request, product);
        handleImageUpdate(request, product);


    }

    private void handleProductNameUpdate(ProductDto request, Product product) {
        if (request.getProductName().isEmpty()) {
            return;
        }
        String name = product.getName();
        String requestProductName = request.getProductName();

        if (requestHasNewProductName(name, requestProductName)) {
            saveAndSetNewNameToProduct(requestProductName, product);
        }
    }

    private boolean requestHasNewProductName(String name, String requestProductName) {
        return name == null && !requestProductName.isEmpty();

    }

    private void saveAndSetNewNameToProduct(String requestProductName, Product product) {
        productService.saveProduct(product);

    }

    private void handleMeasureUnitIdUpdate(ProductDto request, Product product) {
        Integer measureUnitId = request.getMeasureUnitId();
        if (!requestHasSameMeasureUnitIdAsProduct(measureUnitId, product)) {
            MeasureUnit measureUnit = measureUnitService.getMeasureUnitBy(measureUnitId);
            product.setMeasureUnit(measureUnit);
        }
    }

    private boolean requestHasSameMeasureUnitIdAsProduct(Integer measureUnitId, Product product) {
        return measureUnitId.equals(product.getMeasureUnit().getId());
    }


    private void handleImageUpdate(ProductDto request, Product product) {
        if (request.getImageData().isEmpty()) {
            return;
        }
        Image image = product.getImage();
        String requestImageData = request.getImageData();

        if (requestHasNewImage(image, requestImageData)) {
            saveAndSetNewImageToProduct(requestImageData, product);
        } else if (requestHasNewDifferentReplacementImage(image, requestImageData)) {
            updateAndSaveImage(requestImageData, image);
        }
    }

    private boolean requestHasNewImage(Image image, String requestImageData) {
        return image == null && !requestImageData.isEmpty();
    }

    private void saveAndSetNewImageToProduct(String requestImageData, Product product) {
        Image image = ImageConverter.imageDataToImage(requestImageData);
        imageService.saveImage(image);
        product.setImage(image);
    }

    private boolean requestHasNewDifferentReplacementImage(Image image, String requestImageData) {
        boolean hasNewReplacementImage = image != null && !requestImageData.isEmpty();
        boolean hasDifferentImage = hasDifferentImage(image, requestImageData);

        return hasNewReplacementImage && hasDifferentImage;
    }

    private boolean hasDifferentImage(Image image, String requestImageData) {
        byte[] requestImageDataAsByteArray = ImageConverter.getBytesArrayFromImageData(requestImageData);
        return requestImageDataAsByteArray.length != image.getData().length &&
                !Arrays.equals(requestImageDataAsByteArray, image.getData());


    }

    private void updateAndSaveImage(String requestImageData, Image image) {
        byte[] bytesArrayFromImageData = ImageConverter.getBytesArrayFromImageData(requestImageData);
        image.setData(bytesArrayFromImageData);
        imageService.saveImage(image);
    }
}
