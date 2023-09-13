package ee.valiit.roheveeb2back.business.payment;

import ee.valiit.roheveeb2back.business.payment.dto.NewPaymentMethod;
import ee.valiit.roheveeb2back.business.payment.dto.PaymentInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentsController {

    @Resource
    private PaymentsService paymentsService;


    @GetMapping("/payment-methods")
    @Operation(summary = "toob ära maksmisega seotud info", description = "toob ära maksmisega seotud info")
    public List<PaymentInfo> getPaymentMethods() {
        List<PaymentInfo> paymentMethods = paymentsService.getPaymentMethods();
        return paymentMethods;
    }
    @PostMapping("/payment-method")
    @Operation(summary = "lisab maksmisega seotud info", description = "toob ära maksmisega seotud info")
    public void addPaymentMethod(@RequestBody NewPaymentMethod request) {
        paymentsService.addPaymentMethod(request);
    }
}
