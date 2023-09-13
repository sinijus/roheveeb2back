package ee.valiit.roheveeb2back.business.order;

import ee.valiit.roheveeb2back.business.order.dto.OrderInfo;
import ee.valiit.roheveeb2back.business.order.dto.PendingOrderInfo;
import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @GetMapping("/orders/user")
    @Operation(summary = "Leiab kõik kasutaja kinnitatud tellimused",
            description = """
                    Leiab ja tagastab kõik kasutaja töötluses või lõpetatud tellimused.
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: Ühtegi tellimust ei leitud. errorCode: 666",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<OrderInfo> findOrdersInfo(@RequestParam Integer userId) {
        return ordersService.findOrders(userId);
    }

}
