package ee.valiit.roheveeb2back.domain.order;

import ee.valiit.roheveeb2back.business.order.dto.OrderInfo;
import ee.valiit.roheveeb2back.domain.image.Image;
import ee.valiit.roheveeb2back.util.ImageConverter;
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

    @Named("ImagetoImageData")
    static String ImagetoImageData(Image image) {
        return ImageConverter.imageToImageData(image);
    }


}