package ee.valiit.roheveeb2back.business.product.dto;

import ee.valiit.roheveeb2back.domain.product.Product;
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
public class CartProductInfo implements Serializable {
    private Integer orderProductId;
    private String companyName;
    private String productName;
    private String measureUnitName;
    private Integer amount;
    private BigDecimal price;
    private BigDecimal lineTotal;



//    private Integer companyId;
//    private Integer companyLocationId;
//    private Integer companyLocationCountyId;
//    private String companyLocationCountyName;
//    private String companyLocationAddress;
//    private String companyLogoImageData;
//    private String companyPhoneNumber;
//    private String companyRegisterCode;
//    private String companyIban;
//    private Integer typeId;
//    private Integer typeCategoryId;
//    private String typeCategoryName;
//    private String typeName;
//    private Integer measureUnitId;
//    private Integer productId;
//    @NotNull
//    @Size(max = 255)
//
//    @NotNull
}