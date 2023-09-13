package ee.valiit.roheveeb2back.domain.user.usercontact;

import ee.valiit.roheveeb2back.business.user.dto.UserContactInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserContactMapper {
    @Mapping(source = "userEmail", target = "user.email")
    @Mapping(source = "userLocationPostalCode", target = "location.postalCode")
    @Mapping(source = "userLocationAddress", target = "location.address")
    @Mapping(source = "userLocationCountyName", target = "location.county.name")
    @Mapping(source = "userLocationCountyId", target = "location.county.id")
    @Mapping(source = "userLocationId", target = "location.id")
    @Mapping(source = "userContactId", target = "id")
    UserContact toEntity(UserContactInfo userContactInfo);

    @InheritInverseConfiguration(name = "toEntity")
    UserContactInfo toUserContactInfo(UserContact userContact);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserContact partialUpdate(UserContactInfo userContactInfo, @MappingTarget UserContact userContact);

}