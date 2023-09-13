package ee.valiit.roheveeb2back.domain.image;

import ee.valiit.roheveeb2back.business.dto.ImageDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {
    @Mapping(source = "imageData", target = "data")
    @Mapping(source = "imageId", target = "id")
    Image toEntity(ImageDto imageDto);

    @InheritInverseConfiguration(name = "toEntity")
    ImageDto toDto(Image image);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Image partialUpdate(ImageDto imageDto, @MappingTarget Image image);
}

