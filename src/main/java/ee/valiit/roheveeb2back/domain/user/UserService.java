package ee.valiit.roheveeb2back.domain.user;


import ee.valiit.roheveeb_back.business.Status;
import ee.valiit.roheveeb_back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    public User findActiveUserBy(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(email, password, Status.ACTIVE.getLetter());
        User user = ValidationService.getValidUser(optionalUser);
        return user;
    }
}
