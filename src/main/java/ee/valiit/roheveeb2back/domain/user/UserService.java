package ee.valiit.roheveeb2back.domain.user;


import ee.valiit.roheveeb2back.business.Status;
import ee.valiit.roheveeb2back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(email, password, Status.ACTIVE.getLetter());
        return ValidationService.getValidUser(optionalUser);
    }

    public User getUserBy(Integer userId) {
        return userRepository.getReferenceById(userId);
    }


    public void confirmEmailAvailability(String email) {
        boolean emailExists = userRepository.userExistsBy(email);
        ValidationService.validateEmailIsAvailable(emailExists);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
