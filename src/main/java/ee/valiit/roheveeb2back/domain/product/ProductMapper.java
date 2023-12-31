package ee.valiit.roheveeb2back.domain.product;

import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.business.product.dto.CartProductInfo;
import ee.valiit.roheveeb2back.business.product.dto.NewProduct;
import ee.valiit.roheveeb2back.business.product.dto.ProductInfoDto;
import ee.valiit.roheveeb2back.business.product.dto.UpdatedProduct;
import ee.valiit.roheveeb2back.domain.image.Image;
import ee.valiit.roheveeb2back.util.ImageConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {ImageConverter.class, Status.class})
public interface ProductMapper {

    @Mapping(source = "productName", target = "name")
    @Mapping(expression = "java(Status.ACTIVE.getLetter())", target = "status")
    Product toProduct(NewProduct request);

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
    //@Mapping(source = "image.id", target = "productImageId")
    //@Mapping(source = image, target = "productImageData", qualifiedByName = "imageToImageData")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "stockBalance", target = "productBalance")
    ProductInfoDto toProductInfoDto(Product product);

    List<ProductInfoDto> toProductInfoDtos(List<Product> products);

    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        return ImageConverter.imageToImageData(image);
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "productName", target = "name")
    Product partialUpdate(UpdatedProduct newProduct, @MappingTarget Product product);



    @Named("imageDataToImageByteArray")
    static Image imageDataToImageByteArray(String imageData) {
        return ImageConverter.imageDataToImage(imageData);
    }

}

