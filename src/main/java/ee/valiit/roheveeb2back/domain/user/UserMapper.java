package ee.valiit.roheveeb2back.domain.user;

import ee.valiit.roheveeb2back.business.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "roleName", target = "role.name")
    User toEntity(LoginResponse loginResponse);

    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "roleName", target = "role.name")
    User partialUpdate(LoginResponse loginResponse, @MappingTarget User user);
}