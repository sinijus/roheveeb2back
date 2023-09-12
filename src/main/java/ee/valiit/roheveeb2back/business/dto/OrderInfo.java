package ee.valiit.roheveeb2back.business.dto;

import ee.valiit.roheveeb2back.domain.order.Order;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link Order}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo implements Serializable {
    private Integer orderId;
    private Integer transportId;
    private String transportMethod;
    private Integer transportFee;
    private Integer paymentId;
    private String paymentMethod;

    @NotNull
    private String status;
    @NotNull
    private BigDecimal total;
    private Instant sentTime;
}