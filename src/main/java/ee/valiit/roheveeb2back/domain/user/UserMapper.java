package ee.valiit.roheveeb2back.domain.user;

import ee.valiit.roheveeb_back.business.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "role.name", target = "roleName")

    LoginResponse toDto(User user);

}