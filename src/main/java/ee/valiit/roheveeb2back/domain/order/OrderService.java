package ee.valiit.roheveeb2back.domain.order;

import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.domain.user.User;
import ee.valiit.roheveeb2back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderRepository orderRepository;

    public boolean validateIfPendingOrderExists(Integer userId) {
        return orderRepository.orderExistsBy(userId, Status.PENDING.getLetter());
    }

    public Order createAndSaveNewPendingOrder(User user) {
        Order order = new Order();
        order.setStatus(Status.PENDING.getLetter());
        order.setTotal(new BigDecimal(0));
        order.setStartTime(Instant.now());
        order.setUser(user);
        orderRepository.save(order);
        return order;
    }

    public Order getOrderBy(User user) {
        return orderRepository.findOrderBy(user.getId());


    }

    public List<Order> findOrdersBy(Integer userId) {
        List<Order> orders = orderRepository.findOrdersBy(userId, Status.PENDING.getLetter(), Status.IN_PROCESS.getLetter());
        ValidationService.validateAtLeastOneOrderExists(orders);
        return orders;
    }
}
