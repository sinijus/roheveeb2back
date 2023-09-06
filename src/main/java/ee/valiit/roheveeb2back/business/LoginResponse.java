package ee.valiit.roheveeb2back.business;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.roheveeb_back.domain.user.User}
 */
@Value
public class LoginResponse implements Serializable {
    Integer roleId;
    String roleName;
}