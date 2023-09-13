package ee.valiit.roheveeb2back.domain.user.role;

import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    NewCustomer findCustomerById(Integer integer);
}