package ee.valiit.roheveeb2back.domain.order.orderproduct;

import ee.valiit.roheveeb2back.business.orderproduct.dto.OrderProductRequest;
import ee.valiit.roheveeb2back.domain.order.orderproduct.OrderProduct;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderProductMapper {
    @Mapping(source = "productAmount", target = "quantity")
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "orderId", target = "order.id")
    OrderProduct toEntity(OrderProductRequest orderProductRequest);

    @InheritInverseConfiguration(name = "toEntity")
    OrderProductRequest toDto(OrderProduct orderProduct);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderProduct partialUpdate(OrderProductRequest orderProductRequest, @MappingTarget OrderProduct orderProduct);
}