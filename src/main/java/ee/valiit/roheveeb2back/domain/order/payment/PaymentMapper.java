package ee.valiit.roheveeb2back.domain.order.payment;

import ee.valiit.roheveeb2back.business.dto.PaymentDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {

    // TODO: 13/09/2023 mappimine,
    PaymentDto toPaymentDto(Payment payment);

   List <PaymentDto> toPaymentDtos(List <Payment> payments);


}