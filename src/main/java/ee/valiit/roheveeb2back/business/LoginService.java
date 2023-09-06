package ee.valiit.roheveeb2back.business;

import ee.valiit.roheveeb_back.domain.user.UserMapper;
import ee.valiit.roheveeb_back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public void login(String email, String password) {

        userService.findActiveUserBy(email, password);
    }
}
