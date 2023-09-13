package ee.valiit.roheveeb2back.business.orderproduct;

import ee.valiit.roheveeb2back.business.orderproduct.dto.OrderProductRequest;
import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
        orderProductsService.addProductToOrder(request);
    }

    @PutMapping("/order-product")
    @Operation(summary = "Uuendab tabelisse order_product toote kogust",
            description = """
                    Uuendab tabelis order_product Id ja koguse muutuse alusel toote kogust kui lisatav toote kogus on olemas.
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: Selline toote kogus ei ole enam saadaval. errorCode: 777",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void updateProductQuantity(@RequestParam Integer orderProductId, @RequestParam Integer changeInQuantity) {
        orderProductsService.updateProductQuantity(orderProductId, changeInQuantity);
    }


    @DeleteMapping("/order-product")
    @Operation(summary = "Kustutab tabelist order_product orderProductId-ga rea",
            description = "Kustutab ostukorvist toote ehk tabelist order_product orderProductId-ga rea")
    public void deleteProductFromOrder(@RequestParam Integer orderProductId) {
        orderProductsService.deleteProductFromOrder(orderProductId);
    }

}
