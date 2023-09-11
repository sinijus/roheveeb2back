package ee.valiit.roheveeb2back.domain.category;

import ee.valiit.roheveeb2back.business.dto.CategoryDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    @Mapping(source = "name", target = "categoryName")
    @Mapping(source = "id", target = "categoryId")
    CategoryDto toCategoryDto(Category category);

    List<CategoryDto> toCategoryDtos(List<Category> categories);
}