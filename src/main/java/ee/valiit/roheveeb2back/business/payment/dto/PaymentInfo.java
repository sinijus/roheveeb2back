package ee.valiit.roheveeb2back.business.payment.dto;

import ee.valiit.roheveeb2back.domain.order.payment.Payment;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Payment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo implements Serializable {
    private Integer paymentId;
    @NotNull
    @Size(max = 255)
    private String paymentMethod;
    private String bankImageData;
}