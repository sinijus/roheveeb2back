package ee.valiit.roheveeb2back.business.type;

import ee.valiit.roheveeb2back.business.type.dto.TypeDto;
import ee.valiit.roheveeb2back.business.type.dto.TypeRequest;
import ee.valiit.roheveeb2back.domain.product.type.Type;
import ee.valiit.roheveeb2back.domain.product.type.TypeMapper;
import ee.valiit.roheveeb2back.domain.product.type.TypeRepository;
import ee.valiit.roheveeb2back.domain.product.type.TypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypesService {
    @Resource
    private TypeService typeService;
    @Resource
    private TypeMapper typeMapper;


    public List<TypeDto> findAllTypes() {
        List<Type> types = typeService.findAllTypes();
        List<TypeDto> typeDtos = typeMapper.toTypeDtos(types);
        return typeDtos;
    }

    public void addNewProductType(TypeRequest request) {
        typeService.validateTypeNameIsAvailable(request.getTypeName());
        Type type = typeMapper.toType(request);
        typeService.saveType(type);
    }

}
