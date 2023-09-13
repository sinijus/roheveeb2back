package ee.valiit.roheveeb2back.domain.product;

import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.business.dto.ProductDto;
import ee.valiit.roheveeb2back.business.dto.ProductInfoDto;
import ee.valiit.roheveeb2back.domain.image.Image;
import ee.valiit.roheveeb2back.util.ImageConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {ImageConverter.class, Status.class})
public interface ProductMapper {

    @Mapping(source = "productName", target = "name")
    @Mapping(source = "stockBalance", target = "stockBalance")
    @Mapping(source = "price", target = "price")
    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    Product toProduct(ProductDto request);

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "company.location.id", target = "companyLocationId")
    @Mapping(source = "company.location.county.id", target = "companyLocationCountyId")
    @Mapping(source = "company.location.county.name", target = "companyLocationCountyName")
    @Mapping(source = "company.name", target = "companyName")
    @Mapping(source = "type.id", target = "productTypeId")
    @Mapping(source = "type.category.id", target = "productTypeCategoryId")
    @Mapping(source = "type.category.name", target = "productTypeCategoryName")
    @Mapping(source = "type.name", target = "productTypeName")
    @Mapping(source = "measureUnit.id", target = "measureUnitId")
    @Mapping(source = "measureUnit.name", target = "measureUnitName")
    @Mapping(source = "image.id", target = "productImageId")
    @Mapping(source = "image", target = "productImageData", qualifiedByName = "imageToImageData")
    //@Mapping(expression = "java(ImageConverter.imageToImageData(product.getImage())", target = "productImageData")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "stockBalance", target = "productBalance")
    @Mapping(source = "price", target = "price")
    ProductInfoDto toProductInfoDto(Product product);
    List<ProductInfoDto> toProductInfoDtos(List<Product> products);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "productName", target = "name")
    @Mapping(source = "measureUnitId", target = "id")
    Product partialUpdate(ProductDto productDto, @MappingTarget Product product);

    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        return ImageConverter.imageToImageData(image);
    }

    @Named("imageDataToImageByteArray")
    static Image imageDataToImageByteArray(String imageData) {
       return ImageConverter.imageDataToImage(imageData);
    }
}