package ee.valiit.roheveeb2back.business.register;

import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
import ee.valiit.roheveeb2back.domain.user.User;
import ee.valiit.roheveeb2back.domain.user.UserMapper;
import ee.valiit.roheveeb2back.domain.user.UserService;
import ee.valiit.roheveeb2back.domain.user.role.Role;
import ee.valiit.roheveeb2back.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
public class RegisterService {


    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;
    @Resource
    private UserMapper userMapper;


    @Transactional
    public void registerNewCustomer(NewCustomer request) {

        // TODO: valideeri kas e-mail on hõivatud, kui jah, viska viga.
        userService.confirmCustomerEmailAvailability(request.getCustomerEmail());
        
        // TODO: otsi üles objekt roll (customer) roleService.getRoleCustomer()
        NewCustomer customer = roleService.getRoleCustomer(request.getCustomerRoleId());


        // TODO: loo mapperi abil user objekt
        User user = userMapper.toUser(customer);

        // TODO: lisa userile külge roll


        // TODO: salvesta user
        
        // TODO: otsi üles objekt county (countyId abil)
        // TODO: loo mapperi abil location objekt 
        // TODO: lisa locationile külge county
        // TODO: salvesta location
        
        // TODO: loo mapperi abil userContact objekt 
        // TODO: lisa userContact külge user ja location
        // TODO: salvesta userContact
    }
}
