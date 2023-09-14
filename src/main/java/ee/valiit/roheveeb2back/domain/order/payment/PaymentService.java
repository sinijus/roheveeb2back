package ee.valiit.roheveeb2back.domain.order.payment;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Resource
    private PaymentRepository paymentRepository;

    public Payment getPaymentBy(Integer paymentId) {
        return paymentRepository.findById(paymentId).get();
    }
}
