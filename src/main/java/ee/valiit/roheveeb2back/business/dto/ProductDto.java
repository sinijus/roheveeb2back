package ee.valiit.roheveeb2back.business.dto;

import ee.valiit.roheveeb2back.domain.image.Image;
import ee.valiit.roheveeb2back.domain.product.Product;
import jakarta.persistence.JoinColumn;
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

    private Integer companyId;

    private Integer typeId;

    private Integer measureUnitId;

    @JoinColumn(name = "image.id")
    private String imageData;

    @NotNull
    @Size(max = 255)
    private String productName;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer stockBalance;

}