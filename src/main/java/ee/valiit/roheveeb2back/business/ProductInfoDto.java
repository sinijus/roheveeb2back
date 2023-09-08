package ee.valiit.roheveeb2back.business;

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
    private Integer companyId;
    private Integer companyLocationId;
    private Integer companyLocationCountyId;
    private String companyLocationCountyName;
    private String companyName;
    private Integer productTypeId;
    private Integer productTypeCategoryId;
    private String productTypeCategoryName;
    private String productTypeName;
    private Integer measureUnitId;
    private String measureUnitName;
    private Integer productImageId;
    private byte[] productImageData;
    @NotNull
    @Size(max = 255)
    private String productName;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer productBalance;
}