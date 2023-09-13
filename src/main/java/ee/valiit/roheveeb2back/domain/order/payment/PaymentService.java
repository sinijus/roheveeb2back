package ee.valiit.roheveeb2back.domain.order.payment;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentService {

    @Resource
    private PaymentRepository paymentRepository;

    public List<Payment> getPaymentMethods() {
        List<Payment> payments = paymentRepository.findAll();
        return payments;
    }
}
