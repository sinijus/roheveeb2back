package ee.valiit.roheveeb2back.business.profile.dto;

import ee.valiit.roheveeb2back.domain.user.usercontact.UserContact;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link UserContact}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserContactInfo implements Serializable {
    private Integer userContactId;
    private Integer userLocationId;
    private Integer userLocationCountyId;
    private String userLocationCountyName;
    private String userLocationAddress;
    private String userLocationPostalCode;
    private String userEmail;
    @NotNull
    @Size(max = 255)
    private String phoneNumber;
    @NotNull
    @Size(max = 255)
    private String firstName;
    @NotNull
    @Size(max = 255)
    private String lastName;
}