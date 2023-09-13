package ee.valiit.roheveeb2back.domain.user.usercontact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserContactRepository extends JpaRepository<UserContact, Integer> {
    @Query("select u from UserContact u where u.user.id = ?1")
    UserContact getUserContactInfoBy(Integer userId);
}