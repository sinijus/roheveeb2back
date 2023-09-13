package ee.valiit.roheveeb2back.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = ?1 and u.password = ?2 and u.status = ?3")
    Optional <User> findUserBy(String email, String password, String status);

    @Query("select (count(u) > 0) from User u where u.email = ?1")
    boolean userExistsBy(String email, String letter);

}