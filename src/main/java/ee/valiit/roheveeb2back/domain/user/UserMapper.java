package ee.valiit.roheveeb2back.domain.user;

import ee.valiit.roheveeb2back.business.login.dto.LoginResponse;
import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
import ee.valiit.roheveeb2back.domain.company.NewCompany;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);


    @Mapping(source = "email", target = "email")
    @Mapping(source = "customerPassword", target = "password")
    @Mapping(constant = "A", target = "status")
    User toUserCustomer(NewCustomer newCustomer);



    @Mapping(source = "email", target = "email")
    @Mapping(source = "companyPassword", target = "password")
    @Mapping(constant = "A", target = "status")
    User toUserCompany(NewCompany request);

}