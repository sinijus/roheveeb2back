package ee.valiit.roheveeb2back.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select (count(o) > 0) from Order o where o.user.id = ?1 and o.status = ?2")
    boolean orderExistsBy(Integer userId, String status);


    @Query("select o from Order o where o.user.id = ?1 and o.status = ?2")
    Order getOrderIdByUserId(Integer id, String status);
}