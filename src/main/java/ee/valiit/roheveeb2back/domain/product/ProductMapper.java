package ee.valiit.roheveeb2back.domain.product;

import ee.valiit.roheveeb2back.business.ProductInfoDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    // todo: remove unnecessary mappings, solve get image
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
    @Mapping(source = "image.data", target = "productImageData")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "stockBalance", target = "productBalance")
    ProductInfoDto toProductInfoDto(Product product);


}