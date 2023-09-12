package ee.valiit.roheveeb2back.domain.company;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
    @Mapping(source = "companyName", target = "name")
    @Mapping(source = "logoImageId", target = "logoImage.id")
    @Mapping(source = "locationId", target = "location.id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "companyId", target = "id")
    Company toCompany(CompanyDto companyDto);

}

