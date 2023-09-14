package ee.valiit.roheveeb2back.business.measureunit;

import ee.valiit.roheveeb2back.business.dto.MeasureUnitDto;
import ee.valiit.roheveeb2back.domain.product.measureunit.MeasureUnit;
import ee.valiit.roheveeb2back.domain.product.measureunit.MeasureUnitMapper;
import ee.valiit.roheveeb2back.domain.product.measureunit.MeasureUnitService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MeasureUnitsService {
    @Resource
    private MeasureUnitService measureUnitService;
    @Resource
    private MeasureUnitMapper measureUnitMapper;
    public List<MeasureUnitDto> getMeasureUnits() {
        List<MeasureUnit> measureUnits = measureUnitService.getMeasureUnits();
        return measureUnitMapper.toMeasureUnits(measureUnits);
    }
}
