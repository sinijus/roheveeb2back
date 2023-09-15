
package ee.valiit.roheveeb2back.business.payment;

import ee.valiit.roheveeb2back.business.payment.dto.NewPaymentMethod;
import ee.valiit.roheveeb2back.business.payment.dto.PaymentInfo;
import ee.valiit.roheveeb2back.domain.order.payment.Payment;
import ee.valiit.roheveeb2back.domain.order.payment.PaymentService;
import ee.valiit.roheveeb2back.domain.order.payment.PaymentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService {
    @Resource
    private PaymentService paymentService;

    @Resource
    private PaymentMapper paymentMapper;

    public List<PaymentInfo> getPaymentMethods() {
        List<Payment> payments = paymentService.getPaymentMethods();
        List<PaymentInfo> paymentInfos = paymentMapper.toPaymentInfos(payments);
        return paymentInfos;
    }

    public void addPaymentMethod(NewPaymentMethod request) {
    }

    // TODO: Võta requesti küljest imageData
    // TODO: Teisenda see imageData ImageConverteri abil image objektiks
    // TODO: salvesta see image object andmebaasi (imageService -> imageRepository abil)

    // TODO: loo uus payment objekt (võtmesõna new abil)
    // TODO: pane payment objektile külge varasemalt loodud ja salvestatud image objekt
    // TODO: pane payment objektile külge requestist saadud paymentMethodName
    // TODO: salvesta see image objekt andmebaasi (paymentService -> paymentRepository abil)
    // TODO: FINITO

}




