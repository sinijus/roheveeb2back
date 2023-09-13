package ee.valiit.roheveeb2back.domain.product.measureunit;

import ee.valiit.roheveeb2back.business.dto.MeasureUnitDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeasureUnitMapper {
    @Mapping(source = "measureName", target = "name")
    @Mapping(source = "measureId", target = "id")
    MeasureUnit toEntity(MeasureUnitDto measureUnitDto);

    @Mapping(source = "id" , target = "measureId")
    @Mapping(source = "name" , target = "measureName")
    MeasureUnitDto toMeasureUnits(MeasureUnit measureUnit);

    List<MeasureUnitDto> toMeasureUnits(List<MeasureUnit> measureUnits);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MeasureUnit partialUpdate(MeasureUnitDto measureUnitDto, @MappingTarget MeasureUnit measureUnit);
}