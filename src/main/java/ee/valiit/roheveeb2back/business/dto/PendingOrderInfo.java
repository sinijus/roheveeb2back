package ee.valiit.roheveeb2back.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.roheveeb2back.domain.order.Order}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendingOrderInfo implements Serializable {
    private Integer orderId;
    private Integer numberOfProducts = 0;
}