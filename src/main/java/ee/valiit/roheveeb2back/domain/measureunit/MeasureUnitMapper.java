package ee.valiit.roheveeb2back.domain.measureunit;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeasureUnitMapper {
    @Mapping(source = "measureName", target = "name")
    @Mapping(source = "measureId", target = "id")
    MeasureUnit toEntity(MeasureUnitDto measureUnitDto);

    @InheritInverseConfiguration(name = "toEntity")
    MeasureUnitDto toDto(MeasureUnit measureUnit);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MeasureUnit partialUpdate(MeasureUnitDto measureUnitDto, @MappingTarget MeasureUnit measureUnit);
}