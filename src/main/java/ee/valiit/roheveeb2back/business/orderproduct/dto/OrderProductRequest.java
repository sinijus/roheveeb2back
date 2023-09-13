package ee.valiit.roheveeb2back.business.orderproduct.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.roheveeb2back.domain.order.orderproduct.OrderProduct}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductRequest implements Serializable {
    private Integer orderId;
    private Integer productId;
    @NotNull
    private Integer productAmount;
}