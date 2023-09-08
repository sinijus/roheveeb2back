package ee.valiit.roheveeb2back.domain.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Integer id;
    private Integer companyId;
    private Integer companyLocationCountyId;
    private String companyLocationCountyName;
    private String companyName;
    private String companyPhoneNumber;
    private String companyRegisterCode;
    private String companyIban;
    private Integer typeId;
    private Integer typeCategoryId;
    private String typeCategoryName;
    private String typeName;
    private Integer measureUnitId;
    private String measureUnitName;
    private Integer imageId;
    private byte[] imageData;
    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer stockBalance;
    @NotNull
    private String status;
}