package ee.valiit.roheveeb2back.domain.user;

import ee.valiit.roheveeb2back.business.dto.LoginResponse;
import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
import ee.valiit.roheveeb2back.domain.user.role.Role;
import org.mapstruct.*;

import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse loginResponse(User user);


    @Mapping(source = "customerEmail", target = "email")
    @Mapping(source = "customerPassword", target = "password")

    User toUser(NewCustomer request);
}