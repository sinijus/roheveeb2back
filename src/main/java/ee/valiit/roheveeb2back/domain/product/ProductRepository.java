package ee.valiit.roheveeb2back.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.status = ?1")
    List<Product> findAllProductsBy(String status);

    @Query("select p from Product p where p.type.category.id = ?1 and p.type.name = ?2")
    List<Product> findAllCategoriesBy(Integer id, String name);

    @Query("select p from Product  p where p.name = ?1 and p.status = ?2")
    boolean productExistsBy(String productName, String letter);

}