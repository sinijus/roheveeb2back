package ee.valiit.roheveeb2back.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c where c.user.id = ?1")
    Optional<Company> findCompanyBy(Integer userId);

}