package ee.valiit.roheveeb2back.business.payment;
import ee.valiit.roheveeb2back.business.dto.PaymentDto;
import ee.valiit.roheveeb2back.domain.order.payment.Payment;
import ee.valiit.roheveeb2back.domain.order.payment.PaymentService;
import ee.valiit.roheveeb2back.domain.order.payment.PaymentMapper;
import jakarta.annotation.Resource;

import java.util.List;

public class PaymentsService {
    @Resource
    private PaymentService paymentService;

    @Resource
    private PaymentMapper paymentMapper;
}
