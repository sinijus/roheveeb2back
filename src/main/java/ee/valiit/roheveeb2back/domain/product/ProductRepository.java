package ee.valiit.roheveeb2back.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.status = ?1")
    List<Product> findAllProductsBy(String status);
    //String activeStatus


}