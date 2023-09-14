package ee.valiit.roheveeb2back.business.profile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.roheveeb2back.domain.user.usercontact.UserContact}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedCustomerProfile implements Serializable {

    private Integer customerLocationCountyId;
    private String customerLocationAddress;
    private String customerLocationPostalCode;
    private String customerLocationLongitude;
    private String customerLocationLatitude;
    @NotNull
    @Size(max = 255)
    private String customerPhoneNumber;
    @NotNull
    @Size(max = 255)
    private String customerFirstName;
    @NotNull
    @Size(max = 255)
    private String customerLastName;
}