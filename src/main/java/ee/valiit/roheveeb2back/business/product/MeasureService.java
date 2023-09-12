package ee.valiit.roheveeb2back.business.product;

import ee.valiit.roheveeb2back.domain.measureunit.MeasureUnit;
import ee.valiit.roheveeb2back.domain.measureunit.MeasureUnitRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasureService {

    @Resource
    private MeasureUnitRepository measureUnitRepository;

    public MeasureUnit getMeasureUnitBy(Integer measureUnitId) {
        Optional<MeasureUnit> measureUnitOptional = measureUnitRepository.findById(measureUnitId);
        return measureUnitOptional.get();
    }
}
