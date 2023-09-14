package ee.valiit.roheveeb2back.domain.user.role;

import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;

    public Role getRoleCustomer() {
        return roleRepository.getReferenceById(3);
    }
}
