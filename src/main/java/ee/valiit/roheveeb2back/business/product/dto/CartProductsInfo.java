package ee.valiit.roheveeb2back.business.product.dto;

import ee.valiit.roheveeb2back.domain.product.Product;
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
public class CartProductsInfo implements Serializable {
    private Integer companyId;
    private Integer companyLocationId;
    private Integer companyLocationCountyId;
    private String companyLocationCountyName;
    private String companyLocationAddress;
    private String companyLogoImageData;
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
    @NotNull
    @Size(max = 255)
    private String productName;
    @NotNull
    private BigDecimal price;
}