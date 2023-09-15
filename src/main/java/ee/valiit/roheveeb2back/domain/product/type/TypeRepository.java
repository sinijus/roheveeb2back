package ee.valiit.roheveeb2back.domain.product.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TypeRepository extends JpaRepository<Type, Integer> {
    @Query("select (count(t) > 0) from Type t where t.name = ?1")
    boolean typeExistsBy(String typeName);
}