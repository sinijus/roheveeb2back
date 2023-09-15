package ee.valiit.roheveeb2back.domain.order.orderproduct;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public OrderProduct findOrCreateOrderPorduct(Integer productId) {
        Optional<OrderProduct> orderProductOptional = orderProductRepository.getOrderProductBy(productId);
        return orderProductOptional.orElseGet(OrderProduct::new);
    }

    public List<OrderProduct> getOrderProductsBy(Integer orderId) {
        return orderProductRepository.getOrderProductsBy(orderId);

    }

    public OrderProduct getOrderProductByProductId(Integer productId) {
        return orderProductRepository.findByProduct_Id(productId);
    }
}

