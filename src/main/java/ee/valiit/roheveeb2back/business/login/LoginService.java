package ee.valiit.roheveeb2back.business.login;

import ee.valiit.roheveeb2back.business.login.dto.LoginResponse;
import ee.valiit.roheveeb2back.domain.company.Company;
import ee.valiit.roheveeb2back.domain.company.CompanyService;
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
    private CompanyService companyService;

    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String email, String password) {
        User user = userService.findActiveUserBy(email, password);
        return userMapper.toLoginResponse(user);

    }

    public Integer findCompanyId(Integer userId) {
        Company company = companyService.findCompanyByUserId(userId);
        return company.getId();
    }
}
