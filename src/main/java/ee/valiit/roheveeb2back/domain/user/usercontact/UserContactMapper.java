package ee.valiit.roheveeb2back.domain.user.usercontact;

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

}