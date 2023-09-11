package ee.valiit.roheveeb2back.business.order;

import ee.valiit.roheveeb2back.business.dto.PendingOrderInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrdersController {

    @Resource
    private OrdersService ordersService;


//    @PostMapping("/order")
//    public void addProductOrder(@RequestParam Integer orderId, @RequestParam Integer productId) {
//        ordersService.addProductOrder(orderId, productId);
//    }

    @GetMapping("/order/pending")
    public PendingOrderInfo getPendingOrderInfo(@RequestParam Integer userId) {
       return ordersService.getPendingOrderInfo(userId);
    }

}
