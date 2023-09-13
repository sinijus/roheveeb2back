package ee.valiit.roheveeb2back.domain.product.type;

import ee.valiit.roheveeb2back.business.dto.TypeDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeMapper {
    @Mapping(source = "name", target = "typeName")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "id", target = "typeId")
    TypeDto toTypeDto(Type type);

    List<TypeDto> toTypeDtos(List<Type> types);
}