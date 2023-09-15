package ee.valiit.roheveeb2back.business.order.dto;

import ee.valiit.roheveeb2back.domain.order.Order;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Order}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmOrderRequest implements Serializable {
    @NotNull
    private Integer orderId;
    @NotNull
    private Integer transportId;
    @NotNull
    private Integer paymentId;
}