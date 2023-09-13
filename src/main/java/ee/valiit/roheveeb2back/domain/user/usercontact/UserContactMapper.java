package ee.valiit.roheveeb2back.domain.user.usercontact;

import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
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

    @Mapping(source = "customerLastName", target = "lastName")
    @Mapping(source = "customerFirstName", target = "firstName")
    @Mapping(source = "customerPhoneNumber", target = "phoneNumber")
    @Mapping(source = "customerPassword", target = "user.password")
    @Mapping(source = "customerEmail", target = "user.email")
    @Mapping(source = "customerRoleId", target = "id")
    @Mapping(source = "customerLocationLatitude", target = "location.latitude")
    @Mapping(source = "customerLocationLongitude", target = "location.longitude")
    @Mapping(source = "customerLocationPostalCode", target = "location.postalCode")
    @Mapping(source = "customerLocationAddress", target = "location.address")
    @Mapping(source = "customerLocationCountyId", target = "id")
    UserContact toEntity(NewCustomer newCustomer);

    @InheritInverseConfiguration(name = "toEntity")
    NewCustomer toDto(UserContact userContact);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserContact partialUpdate(NewCustomer newCustomer, @MappingTarget UserContact userContact);
}