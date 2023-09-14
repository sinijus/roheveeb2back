package ee.valiit.roheveeb2back.domain.location;

import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {



    Location toLocation(NewCustomer request);

}