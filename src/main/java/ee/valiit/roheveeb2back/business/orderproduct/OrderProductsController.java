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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
