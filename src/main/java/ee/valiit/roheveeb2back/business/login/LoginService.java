package ee.valiit.roheveeb2back.business.login;

import ee.valiit.roheveeb2back.business.dto.LoginResponse;
import ee.valiit.roheveeb2back.domain.user.User;
import ee.valiit.roheveeb2back.domain.user.UserMapper;
import ee.valiit.roheveeb2back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String email, String password) {
        User user = userService.findActiveUserBy(email, password);
        return userMapper.loginResponse(user);

    }
}
