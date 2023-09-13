package ee.valiit.roheveeb2back.domain.user.usercontact;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserContactService {

    @Resource
    private UserContactRepository userContactRepository;

    public UserContact getUserContactInfoBy(Integer userId) {
        return userContactRepository.getUserContactInfoBy(userId);
    }
}
