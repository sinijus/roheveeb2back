package ee.valiit.roheveeb2back.domain.order.orderproduct;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    @Resource
    private OrderProductRepository orderProductRepository;
    public void saveOrderProduct(OrderProduct orderProduct) {
        orderProductRepository.save(orderProduct);
    }

    public void deleteOrderProductBy(Integer orderProductId) {
        orderProductRepository.deleteById(orderProductId);
    }

    public OrderProduct getOrderProductrequestBy(Integer productId) {
        OrderProduct orderProduct = orderProductRepository.getOrderProductBy(productId);
        return orderProduct;
    }
}
