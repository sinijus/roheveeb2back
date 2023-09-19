package ee.valiit.roheveeb2back.domain.user.usercontact;

import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
import ee.valiit.roheveeb2back.business.profile.dto.UserContactInfo;
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


    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserContact partialUpdate(UserContactInfo userContactInfo, @MappingTarget UserContact userContact);



    @Mapping(source = "customerPhoneNumber", target = "phoneNumber")
    @Mapping(source = "customerFirstName", target = "firstName")
    @Mapping(source = "customerLastName", target = "lastName")
    UserContact toUserContact(NewCustomer newCustomer);



}