package ee.valiit.roheveeb2back.domain.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;

    public Role getRoleCustomer() {
        return roleRepository.getReferenceById(3);
    }

    public Role getRoleCompany() {
        return roleRepository.getReferenceById(2);


    }
}
