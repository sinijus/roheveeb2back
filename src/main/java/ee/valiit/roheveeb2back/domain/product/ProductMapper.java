package ee.valiit.roheveeb2back.domain.product;

import ee.valiit.roheveeb2back.business.ProductInfoDto;
import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.domain.Image;
import ee.valiit.roheveeb2back.util.ImageConverter;
import org.mapstruct.*;
import org.mapstruct.Named;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Status.class})
public interface ProductMapper {

    // todo: remove unnecessary mappings?, solve get image
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

//    @Mapping(source = "image.id", target = "productImageId")
//    @Mapping(source = "image.data", target = "productImageData", qualifiedByName = "imageToImageData")

    @Mapping(source = "name", target = "productName")
    @Mapping(source = "stockBalance", target = "productBalance")
    @Mapping(source = "price", target = "price")
    ProductInfoDto toProductInfoDto(Product product);
    List<ProductInfoDto> toProductInfoDtos(List<Product> products);

    @Named("imageToImageData")
    public static String imageToImageData(Image image) {
        return ImageConverter.imageToImageData(image);
    }
}