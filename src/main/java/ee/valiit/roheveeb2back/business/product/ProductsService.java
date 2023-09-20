package ee.valiit.roheveeb2back.business.product;

import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.business.product.dto.NewProduct;
import ee.valiit.roheveeb2back.business.product.dto.ProductInfoDto;
import ee.valiit.roheveeb2back.business.product.dto.UpdatedProduct;
import ee.valiit.roheveeb2back.domain.company.Company;
import ee.valiit.roheveeb2back.domain.company.CompanyMapper;
import ee.valiit.roheveeb2back.domain.company.CompanyService;
import ee.valiit.roheveeb2back.domain.image.Image;
import ee.valiit.roheveeb2back.domain.image.ImageService;
import ee.valiit.roheveeb2back.domain.product.Product;
import ee.valiit.roheveeb2back.domain.product.ProductMapper;
import ee.valiit.roheveeb2back.domain.product.ProductService;
import ee.valiit.roheveeb2back.domain.product.measureunit.MeasureUnit;
import ee.valiit.roheveeb2back.domain.product.measureunit.MeasureUnitService;
import ee.valiit.roheveeb2back.domain.product.type.Type;
import ee.valiit.roheveeb2back.domain.product.type.TypeMapper;
import ee.valiit.roheveeb2back.domain.product.type.TypeService;
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
    private TypeMapper typeMapper;
    @Resource
    private CompanyMapper companyMapper;

    public List<ProductInfoDto> findAllProducts() {
        List<Product> products = productService.findAllProducts();
        return productMapper.toProductInfoDtos(products);
    }

    @Transactional
    public void addNewProduct(NewProduct request) {
        productService.confirmProductNameAvailability(request.getProductName());
        createAndSaveProduct(request);
    }

    private void createAndSaveProduct(NewProduct request) {
        Product product = createProduct(request);
        productService.saveProduct(product);
    }

    private Product createProduct(NewProduct request) {
        Company company = companyService.getCompanyByCompanyId(request.getCompanyId());
        Type type = typeService.getTypeBy(request.getTypeId());
        MeasureUnit measureUnit = measureUnitService.getMeasureUnitBy(request.getMeasureUnitId());
        Image image = createAndSaveImage(request.getImageData());

        Product product = productMapper.toProduct(request);
        product.setCompany(company);
        product.setType(type);
        product.setMeasureUnit(measureUnit);
        product.setImage(image);
        return product;
    }

    private Image createAndSaveImage(String imageData) {
        if (imageData != null) {
            Image image = ImageConverter.imageDataToImage(imageData);
            imageService.saveImage(image);
            return image;
        }
        return null;
    }

    public void deleteProduct(Integer productId) {
        Product product = productService.getProductBy(productId);
        product.setStatus(Status.DELETED.getLetter());
        productService.saveProduct(product);
    }

    @Transactional
    public void updateProductInfo(Integer productId, UpdatedProduct request) {
        Product product = productService.getProductBy(productId);
        productMapper.partialUpdate(request, product);
        handleMeasureUnitIdUpdate(request, product);
        handleImageUpdate(request, product);
        productService.saveProduct(product);
    }


    private void handleMeasureUnitIdUpdate(UpdatedProduct request, Product product) {
        Integer measureUnitId = request.getMeasureUnitId();
        if (!requestHasSameMeasureUnitIdAsProduct(measureUnitId, product)) {
            MeasureUnit measureUnit = measureUnitService.getMeasureUnitBy(measureUnitId);
            product.setMeasureUnit(measureUnit);
        }
    }

    private boolean requestHasSameMeasureUnitIdAsProduct(Integer measureUnitId, Product product) {
        return measureUnitId.equals(product.getMeasureUnit().getId());
    }


    private void handleImageUpdate(UpdatedProduct request, Product product) {
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
