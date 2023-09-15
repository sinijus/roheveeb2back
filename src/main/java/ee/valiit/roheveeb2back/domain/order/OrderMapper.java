package ee.valiit.roheveeb2back.domain.order;

import ee.valiit.roheveeb2back.business.order.dto.ConfirmOrderRequest;
import ee.valiit.roheveeb2back.business.order.dto.OrderInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {


    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "transport.id", target = "transportId")
    @Mapping(source = "transport.method", target = "transportMethod")
    @Mapping(source = "transport.fee", target = "transportFee")
    @Mapping(source = "payment.id", target = "paymentId")
    @Mapping(source = "payment.method", target = "paymentMethod")
    OrderInfo toOrderInfo(Order order);

    List<OrderInfo> toOrdersInfo(List<Order> orders);

    @Mapping(source = "paymentId", target = "payment.id")
    @Mapping(source = "transportId", target = "transport.id")
    @Mapping(source = "orderId", target = "id")
    Order toOrder(ConfirmOrderRequest confirmOrderRequest);

}