package ee.valiit.roheveeb2back.business.orderproduct;

import ee.valiit.roheveeb2back.business.orderproduct.dto.OrderProductRequest;
import ee.valiit.roheveeb2back.domain.order.Order;
import ee.valiit.roheveeb2back.domain.order.OrderService;
import ee.valiit.roheveeb2back.domain.order.orderproduct.OrderProduct;
import ee.valiit.roheveeb2back.domain.order.orderproduct.OrderProductService;
import ee.valiit.roheveeb2back.domain.product.Product;
import ee.valiit.roheveeb2back.domain.product.ProductService;
import ee.valiit.roheveeb2back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private OrderService orderService;

    @Resource
    private OrderProductService orderProductService;

    public void addProductToOrderProduct(OrderProductRequest request) {
        //TODO: validate that product is not placed already first, then validate quantity or change of it
//        Product product = productService.getProductBy(request.getProductId());
//        ValidationService.validateAddedProductAmountExists(request.getProductId(), product.getStockBalance());
//        Order order = orderService.getOrderBy(request.getOrderId());
//        OrderProduct orderProduct = orderProductService.getOrderProductrequestBy(request.getProductId());
//        if (orderProduct == null) {
//            orderProduct = new OrderProduct();
//            orderProduct.setProduct(product);
//            orderProduct.setOrder(order);
//        }
//        orderProduct.setQuantity(request.getProductAmount());
//        orderProductService.saveOrderProduct(orderProduct);
    }

    public void deleteProductFromOrder(Integer orderProductId) {
        orderProductService.deleteOrderProductBy(orderProductId);

    }

    public void updateProductQuantity(Integer orderProductId, Integer changeInQuantity) {
        //TODO: go on from here
    }

}
