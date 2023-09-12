package ee.valiit.roheveeb2back.business.order;

import ee.valiit.roheveeb2back.business.dto.PendingOrderInfo;
import ee.valiit.roheveeb2back.domain.order.Order;
import ee.valiit.roheveeb2back.domain.order.OrderMapper;
import ee.valiit.roheveeb2back.domain.order.OrderService;
import ee.valiit.roheveeb2back.domain.user.User;
import ee.valiit.roheveeb2back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Resource
    private OrderService orderService;
    @Resource
    private UserService userService;
    @Resource
    private OrderMapper orderMapper;




    public PendingOrderInfo getPendingOrderInfo(Integer userId) {
        boolean pendingOrderExists = orderService.validateIfPendingOrderExists(userId);
        if (!pendingOrderExists) {
            User user = userService.getUserBy(userId);

            Order order = orderService.createAndSaveNewPendingOrder(user);
            PendingOrderInfo pendingOrderInfo = new PendingOrderInfo();
            pendingOrderInfo.setOrderId(order.getId());
            return pendingOrderInfo;
        }
        User user = userService.getUserBy(userId);
        Order order = orderService.getOrderBy(user);
        PendingOrderInfo pendingOrderInfo = new PendingOrderInfo();
        pendingOrderInfo.setOrderId(order.getId());
        return pendingOrderInfo;
    }
}
