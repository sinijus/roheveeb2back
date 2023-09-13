package ee.valiit.roheveeb2back.business.user;

import ee.valiit.roheveeb2back.business.user.dto.UserContactInfo;
import ee.valiit.roheveeb2back.domain.user.UserService;
import ee.valiit.roheveeb2back.domain.user.usercontact.UserContact;
import ee.valiit.roheveeb2back.domain.user.usercontact.UserContactMapper;
import ee.valiit.roheveeb2back.domain.user.usercontact.UserContactService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Resource
    private UserService userService;

    @Resource
    private UserContactService userContactService;

    @Resource
    private UserContactMapper userContactMapper;


    public UserContactInfo getUserContactInfo(Integer userId) {
        UserContact userContact = userContactService.getUserContactInfoBy(userId);
        return userContactMapper.toUserContactInfo(userContact);
    }
}
