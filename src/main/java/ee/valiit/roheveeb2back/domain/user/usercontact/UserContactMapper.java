package ee.valiit.roheveeb2back.domain.user.usercontact;

import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
import ee.valiit.roheveeb2back.business.user.dto.UserContactInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserContactMapper {



    @Mapping(source = "user.email", target = "userEmail")
    @Mapping(source = "location.postalCode", target = "userLocationPostalCode")
    @Mapping(source = "location.address", target = "userLocationAddress")
    @Mapping(source = "location.county.name", target = "userLocationCountyName")
    @Mapping(source = "location.county.id", target = "userLocationCountyId")
    @Mapping(source = "location.id", target = "userLocationId")
    @Mapping(source = "id", target = "userContactId")
    UserContactInfo toUserContactInfo(UserContact userContact);

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