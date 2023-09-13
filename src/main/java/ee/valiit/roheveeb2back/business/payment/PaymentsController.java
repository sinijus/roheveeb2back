package ee.valiit.roheveeb2back.business.payment;

import ee.valiit.roheveeb2back.business.dto.PaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentsController {
    @GetMapping("/payment-methods")
    @Operation(summary = "toob ära maksmisega seotud info", description = "toob ära maksmisega seotud info")
    public List<PaymentDto> getPaymentMethods() {

        return null;
    }
}
