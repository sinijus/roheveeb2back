package ee.valiit.roheveeb2back.business.order;

import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.business.order.dto.ConfirmOrderRequest;
import ee.valiit.roheveeb2back.business.order.dto.OrderInfo;
import ee.valiit.roheveeb2back.business.order.dto.PendingOrderInfo;
import ee.valiit.roheveeb2back.domain.order.Order;
import ee.valiit.roheveeb2back.domain.order.OrderMapper;
import ee.valiit.roheveeb2back.domain.order.OrderService;
import ee.valiit.roheveeb2back.domain.order.orderproduct.OrderProduct;
import ee.valiit.roheveeb2back.domain.order.orderproduct.OrderProductService;
import ee.valiit.roheveeb2back.domain.order.payment.PaymentService;
import ee.valiit.roheveeb2back.domain.order.transport.OrderTransportService;
import ee.valiit.roheveeb2back.domain.user.User;
import ee.valiit.roheveeb2back.domain.user.UserService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class OrdersService {
    @Resource
    private OrderService orderService;
    @Resource
    private UserService userService;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderProductService orderProductService;
    @Resource
    private OrderTransportService orderTransportService;
    @Resource
    private PaymentService paymentService;

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

    public List<OrderInfo> findOrders(Integer userId) {
        List<Order> orders = orderService.findOrdersBy(userId);
       return orderMapper.toOrdersInfo(orders);

    }

    @Transactional
    public void confirmOrder(ConfirmOrderRequest request) {
        Order order = orderService.getOrderBy(request.getOrderId());
        setOrder(request, order);
        orderService.saveOrder(order);
    }

    private void setOrder(ConfirmOrderRequest request, Order order) {
        order.setTransport(orderTransportService.getTransportBy(request.getTransportId()));
        order.setPayment(paymentService.getPaymentBy(request.getPaymentId()));
        order.setStatus(Status.IN_PROCESS.getLetter());
        order.setSentTime(Instant.now());
        order.setOrderNumber(generateOrderNumber(order.getSentTime(), order.getId()));
        order.setTotal(calculateValueOfAllOrderProducts(request.getOrderId()));
    }

    private String generateOrderNumber(Instant setOrderTime, Integer orderId) {
        StringBuilder stringBuilder = new StringBuilder();
        modifyAndAppendDateComponent(setOrderTime, stringBuilder);
        modifyAndAppendOrderNumberComponent(orderId, stringBuilder);
        return stringBuilder.toString();
    }

    private static void modifyAndAppendDateComponent(Instant startTime, StringBuilder stringBuilder) {
        String[] orderNumberDateComponents = startTime.toString().split(":");
        stringBuilder.append(orderNumberDateComponents[0].replace("-",""));
    }

    private static void modifyAndAppendOrderNumberComponent(Integer orderId, StringBuilder stringBuilder) {
        String orderNumberComponent = String.format("%03d", orderId);
        stringBuilder.append(orderNumberComponent);
    }

    private BigDecimal calculateValueOfAllOrderProducts(Integer orderId) {
        List<OrderProduct> orderProducts = orderProductService.getOrderProductsBy(orderId);
        double totalTwo = 0.00;
        for (OrderProduct orderProduct : orderProducts) {
            Double price =  Double.parseDouble(String.valueOf(orderProduct.getProduct().getPrice()));
            Integer quantity = orderProduct.getQuantity();
            totalTwo += price * quantity;
        }
        return BigDecimal.valueOf(totalTwo);
    }
}
