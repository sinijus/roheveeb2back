package ee.valiit.roheveeb2back.domain.type;

import ee.valiit.roheveeb2back.validation.ValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> findAllTypes() {
        List<Type> types = typeRepository.findAll();
        ValidationService.validateAtLeastOneTypeExists(types);
        return types;
    }
}
