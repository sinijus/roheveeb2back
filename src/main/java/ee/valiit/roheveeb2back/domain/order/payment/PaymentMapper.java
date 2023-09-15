package ee.valiit.roheveeb2back.domain.order.payment;

import ee.valiit.roheveeb2back.business.payment.dto.PaymentInfo;
import ee.valiit.roheveeb2back.domain.image.Image;
import ee.valiit.roheveeb2back.util.ImageConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {

    // TODO: 13/09/2023 mappimine,
    @Mapping(source = "id", target = "paymentId")
    @Mapping(source = "method", target = "paymentMethod")
    @Mapping(source = "bankLogo", target = "bankImageData", qualifiedByName = "bankLogoToBankImageData")
    PaymentInfo toPaymentInfo(Payment payment);

   List <PaymentInfo> toPaymentInfos(List <Payment> payments);

   @Named("bankLogoToBankImageData")
   static String bankLogoToBankImageData(Image bankLogo) {
       String imageData = ImageConverter.imageToImageData(bankLogo);
       return imageData;
   }


}