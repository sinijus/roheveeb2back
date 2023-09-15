package ee.valiit.roheveeb2back.business.user.dto;

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
public class CompanyInfo implements Serializable {
    private String userEmail;
    private String userPassword;
    private String locationCountyName;
    private String locationAddress;
    private String locationPostalCode;
    private String locationLongitude;
    private String locationLatitude;
    private byte[] logoImageData;
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