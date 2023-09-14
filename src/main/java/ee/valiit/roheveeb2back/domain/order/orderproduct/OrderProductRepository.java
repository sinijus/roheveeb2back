package ee.valiit.roheveeb2back.domain.order.orderproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
    @Query("select o from OrderProduct o where o.product.id = ?1")
    Optional<OrderProduct> getOrderProductBy(Integer productId);

    @Query("select o from OrderProduct o where o.order.id = ?1")
    List<OrderProduct> getOrderProductsBy(Integer id);



}