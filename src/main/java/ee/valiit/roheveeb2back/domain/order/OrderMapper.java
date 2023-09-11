package ee.valiit.roheveeb2back.domain.order;

import ee.valiit.roheveeb2back.business.dto.OrderDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    @Mapping(source = "orderStatus", target = "status")
    @Mapping(source = "userUserId", target = "user.id")
    Order toOrder(OrderDto orderDto);




}