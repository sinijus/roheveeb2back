package ee.valiit.roheveeb2back.domain.order.orderproduct;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<OrderProduct> getOrderProductrequestBy(Integer productId) {
        Optional<OrderProduct> orderProduct = orderProductRepository.getOrderProductBy(productId);
        return orderProduct;
    }
}
