package ee.valiit.roheveeb2back.business.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link ee.valiit.roheveeb2back.domain.product.Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDto implements Serializable {
    private Integer productId;
    @NotNull(message = "Väli companyId on kohustuslik")
    private Integer companyId;
    private Integer companyLocationId;
    private Integer companyLocationCountyId;
    private String companyLocationCountyName;
    private String companyName;
    @NotNull(message = "Väli productTypeId on kohustuslik")
    private Integer productTypeId;
    private String productTypeName;
    @NotNull(message = "Väli productTypeCategoryId on kohustuslik")
    private Integer productTypeCategoryId;
    private String productTypeCategoryName;
    @NotNull(message = "Väli measureUnitId on kohustuslik")
    private Integer measureUnitId;
    private String measureUnitName;
    private Integer productImageId;
    private String productImageData;
    @NotNull(message = "Väli productName on kohustuslik")
    @Size(max = 255)
    private String productName;
    @NotNull(message = "Väli price on kohustuslik")
    private BigDecimal price;
    @NotNull(message = "Väli productBalance on kohustuslik")
    private Integer productBalance;
}