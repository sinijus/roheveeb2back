package ee.valiit.roheveeb2back.domain.location.county;

import ee.valiit.roheveeb2back.business.county.dto.CountyDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountyMapper {
    @Mapping(source = "name", target = "countyName")
    @Mapping(source = "id", target = "countyId")
    CountyDto toCountyDto(County county);
    List<CountyDto> toCountyDtos(List<County>counties);

}