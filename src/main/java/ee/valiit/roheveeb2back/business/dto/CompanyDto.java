package ee.valiit.roheveeb2back.business.dto;

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
public class CompanyDto implements Serializable {
    private Integer companyId;
    private Integer userId;
    private Integer locationId;
    private Integer logoImageId;
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