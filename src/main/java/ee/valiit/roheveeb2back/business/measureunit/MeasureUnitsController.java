package ee.valiit.roheveeb2back.business.measureunit;

import ee.valiit.roheveeb2back.business.dto.MeasureUnitDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MeasureUnitsController {
    @Resource
    private MeasureUnitsService measureUnitsService;

    @GetMapping("/measureunits")
    @Operation(summary = "Kõikide ühikute küsimine. Tagastab kõik ühikud",
            description = """
            Kõikide ühikute küsimine. Tagastab kõik ühikud
            """)

    public List<MeasureUnitDto> getMeasureUnits() {
        return measureUnitsService.getMeasureUnits();
    }
}
