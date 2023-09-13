package ee.valiit.roheveeb2back.business.order;

import ee.valiit.roheveeb2back.business.dto.PendingOrderInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Operation(summary = "Kontrollib kas order on tehtud",
            description = """
                    Kui order on tehtud, siis tagastab orderId ja numberOfProducts. 
                    Kui order ei ole tehtud, siis teeb orderi ja tagastab orderId ja numberOfProducts.
                   """)
    public PendingOrderInfo getPendingOrderInfo(@RequestParam Integer userId) {
       return ordersService.getPendingOrderInfo(userId);
    }

    @GetMapping("/payment")
    @Operation(summary = "toob ära maksmisega seotud info", description = """ toob ära maksmisega seotud info
            """)
    public void getPaymentInfo(@RequestParam Integer userId) {

    }

}
