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
public class NewPaymentMethod implements Serializable {
    private String paymentMethodName;
    private String imageData;
}