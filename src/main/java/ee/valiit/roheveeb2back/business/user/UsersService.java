package ee.valiit.roheveeb2back.business.user;

import ee.valiit.roheveeb2back.business.user.dto.CompanyInfo;
import ee.valiit.roheveeb2back.business.user.dto.UserContactInfo;
import ee.valiit.roheveeb2back.domain.company.Company;
import ee.valiit.roheveeb2back.domain.company.CompanyMapper;
import ee.valiit.roheveeb2back.domain.company.CompanyService;
import ee.valiit.roheveeb2back.domain.user.usercontact.UserContact;
import ee.valiit.roheveeb2back.domain.user.usercontact.UserContactMapper;
import ee.valiit.roheveeb2back.domain.user.usercontact.UserContactService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Resource
    private UserContactService userContactService;

    @Resource
    private CompanyService companyService;

    @Resource
    private UserContactMapper userContactMapper;

    @Resource
    private CompanyMapper companyMapper;

    public UserContactInfo getUserContactInfo(Integer userId) {
        UserContact userContact = userContactService.getUserContactInfoBy(userId);
        return userContactMapper.toUserContactInfo(userContact);
    }

    public CompanyInfo getCompanyInfo(Integer companyId) {
        Company companyInfo = companyService.getCompanyInfo(companyId);
        return companyMapper.toCompanyInfo(companyInfo);
    }
}
