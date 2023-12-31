package ee.valiit.roheveeb2back.domain.order.orderproduct;

import ee.valiit.roheveeb2back.business.orderproduct.dto.OrderProductRequest;
import ee.valiit.roheveeb2back.business.product.dto.CartProductInfo;
import org.mapstruct.*;

import java.util.List;

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

    @Mapping(source = "id", target = "orderProductId")
    @Mapping(source = "product.company.name", target = "companyName")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.measureUnit.name", target = "measureUnitName")
    @Mapping(source = "quantity", target = "amount")
    @Mapping(source = "product.price", target = "price")
    CartProductInfo toCartProductsInfos(OrderProduct orderProducts);


    List<CartProductInfo> toCartProductsInfos(List<OrderProduct> orderProducts);
}