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
public class NewProduct implements Serializable {
    @NotNull
    private Integer companyId;
    @NotNull
    private Integer typeId;
    @NotNull
    private Integer measureUnitId;

    private String imageData;

    @NotNull
    @Size(max = 255)
    private String productName;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer stockBalance;

}