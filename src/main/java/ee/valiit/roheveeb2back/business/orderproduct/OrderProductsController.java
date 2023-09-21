package ee.valiit.roheveeb2back.business.orderproduct;

import ee.valiit.roheveeb2back.business.orderproduct.dto.OrderProductRequest;
import ee.valiit.roheveeb2back.business.product.dto.CartProductInfo;
import ee.valiit.roheveeb2back.business.product.dto.CartResponse;
import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderProductsController {

    @Resource
    private OrderProductsService orderProductsService;

    @PostMapping("/order-product")
    @Operation(summary = "Lisab tabelisse order_product tooteId, toote koguse ja orderId",
            description = """
                    Lisab tabelisse order_product tooteId, toote koguse ja orderId
                    kui lisatav toote kogus on olemas.""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: Selline toote kogus ei ole enam saadaval. errorCode: 777",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void addProductToOrder(@RequestBody @Valid OrderProductRequest request) {
        orderProductsService.addProductToOrderProduct(request);
    }

    @DeleteMapping("/order-product")
    @Operation(summary = "Kustutab tabelist order_product orderProductId-ga rea",
            description = "Kustutab ostukorvist toote ehk tabelist order_product orderProductId-ga rea")
    public void deleteProductFromOrder(@RequestParam Integer orderProductId) {
        orderProductsService.deleteProductFromOrder(orderProductId);
    }

    @GetMapping("/cart")
    @Operation(summary = "Toob ära kogu ostukorvi sisu",
            description = " Toob ära toote nime, koguse, hinna, müüja nime ja -logo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: Ostukorvis ei leitud ühtegi lisatud toodet. errorCode: 2222",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public CartResponse getCustomerCartContent(@RequestParam Integer orderId) {
        return orderProductsService.getCustomerCartContent(orderId);
    }

}
