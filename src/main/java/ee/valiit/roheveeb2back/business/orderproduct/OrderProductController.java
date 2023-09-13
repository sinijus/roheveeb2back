package ee.valiit.roheveeb2back.business.orderproduct;

import ee.valiit.roheveeb2back.business.orderproduct.dto.OrderProductRequest;
import ee.valiit.roheveeb2back.domain.order.orderproduct.OrderProduct;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProductController {

    @Resource
    private OrderProductService orderProductService;

    @PostMapping("/orderproduct")
    public void addProductToOrder(@RequestBody @Valid OrderProductRequest request) {
        OrderProductService.addProductToOrder(request);
    }

}
