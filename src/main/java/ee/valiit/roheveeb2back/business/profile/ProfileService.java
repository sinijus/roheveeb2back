package ee.valiit.roheveeb2back.business.profile;

import ee.valiit.roheveeb2back.domain.user.User;
import ee.valiit.roheveeb2back.domain.user.UserService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Resource
    private UserService userService;
    @Transactional
    public void updateCustomerProfile(Integer userId, UpdatedCustomerProfile request) {


    }
}
