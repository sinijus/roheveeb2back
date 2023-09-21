package ee.valiit.roheveeb2back.business.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse  {
    private BigDecimal grandTotalSum;
    private List<CartProductInfo> cartProducts;
}
