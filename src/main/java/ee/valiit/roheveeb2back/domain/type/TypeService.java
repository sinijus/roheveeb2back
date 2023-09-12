package ee.valiit.roheveeb2back.domain.type;

import ee.valiit.roheveeb2back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Resource
    private TypeRepository typeRepository;

    public List<Type> findAllTypes() {
        List<Type> types = typeRepository.findAll();
        ValidationService.validateAtLeastOneTypeExists(types);
        return types;
    }

    public Type getTypeBy(Integer typeId) {
        Optional<Type> typeOptional = typeRepository.findById(typeId);
        return typeOptional.get();

    }
}
