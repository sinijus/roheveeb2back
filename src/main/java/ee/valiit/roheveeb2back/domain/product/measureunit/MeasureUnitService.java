package ee.valiit.roheveeb2back.domain.product.measureunit;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasureUnitService {

    @Resource
    private MeasureUnitRepository measureUnitRepository;

    public MeasureUnit getMeasureUnitBy(Integer measureUnitId) {
        Optional<MeasureUnit> measureUnitOptional = measureUnitRepository.findById(measureUnitId);
        return measureUnitOptional.get();
    }

    public List<MeasureUnit> getMeasureUnits() {
        return measureUnitRepository.findAll();

    }
}
