package ee.valiit.roheveeb2back.business.orderproduct;

import ee.valiit.roheveeb2back.business.orderproduct.dto.OrderProductRequest;
import ee.valiit.roheveeb2back.domain.order.Order;
import ee.valiit.roheveeb2back.domain.order.OrderService;
import ee.valiit.roheveeb2back.domain.order.orderproduct.OrderProduct;
import ee.valiit.roheveeb2back.domain.order.orderproduct.OrderProductService;
import ee.valiit.roheveeb2back.business.product.dto.CartProductsInfo;
import ee.valiit.roheveeb2back.domain.product.Product;
import ee.valiit.roheveeb2back.domain.product.ProductMapper;
import ee.valiit.roheveeb2back.domain.product.ProductService;
import ee.valiit.roheveeb2back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private OrderService orderService;

    @Resource
    private OrderProductService orderProductService;

    @Resource
    private ProductMapper productMapper;


    public void addProductToOrderProduct(OrderProductRequest request) {
        OrderProduct orderProduct = orderProductService.findOrCreateOrderPorduct(request);
        validateAndSetOrderProduct(request, orderProduct);
        orderProductService.saveOrderProduct(orderProduct);
    }

    private void validateAndSetOrderProduct(OrderProductRequest request, OrderProduct orderProduct) {
        Product product = productService.getProductBy(request.getProductId());
        Order order = orderService.getOrderBy(request.getOrderId());
        orderProduct.setProduct(product);
        orderProduct.setOrder(order);
        if (orderProduct.getQuantity() == null) {
            orderProduct.setQuantity(0);
        }
        ValidationService.calculateAndValidateAddedProductAmountExists(orderProduct.getQuantity(), request.getProductAmount(), product.getStockBalance());
        ValidationService.calculateAndValidateAddedProductAmountExists(orderProduct.getQuantity(), request.getProductAmount(), product.getStockBalance());
        orderProduct.setQuantity(orderProduct.getQuantity() + request.getProductAmount());
    }

    public void deleteProductFromOrder(Integer orderProductId) {
        orderProductService.deleteOrderProductBy(orderProductId);

    }

    public List<CartProductsInfo> getCustomerCartContent(Integer orderId) {
        List<OrderProduct> orderProducts = orderProductService.findAllOrderProducts(orderId);
        List<Product> products = new ArrayList<>();
        for (OrderProduct orderProduct : orderProducts) {
            products.add(productService.getProductsBy(orderProduct.getProduct().getId()));
        }
        return productMapper.toCartProductsInfos(products);
    }
}