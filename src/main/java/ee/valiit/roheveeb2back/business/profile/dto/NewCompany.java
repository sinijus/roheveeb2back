package ee.valiit.roheveeb2back.business.profile.dto;

import ee.valiit.roheveeb2back.domain.company.Company;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Company}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCompany implements Serializable {
    //    private Integer userId;
//    private Integer userRoleId;
    private String email;
    private String companyPassword;
    //    private String status;
//    private Integer locationId;
    private Integer countyId;
    private String address;
    private String postalCode;
    private String longitude;
    private String latitude;
    //    private Integer logoImageId;
    private String logoImagedata;
    @NotNull
    @Size(max = 255)
    private String companyName;
    @NotNull
    @Size(max = 255)
    private String phoneNumber;
    @NotNull
    @Size(max = 255)
    private String registerCode;
    @NotNull
    @Size(max = 255)
    private String iban;
}