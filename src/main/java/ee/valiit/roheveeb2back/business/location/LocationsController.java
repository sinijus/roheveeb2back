package ee.valiit.roheveeb2back.business.location;

import ee.valiit.roheveeb2back.business.CountyDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController


public class LocationsController {
    @Resource
    private LocationsService locationsService;
    @GetMapping("/counties")
    @Operation(summary = "leiab süsteemist kõik maakonnad.",
    description = """
    tagastab info koos countyId ja countyNamega
""")
    public List<CountyDto> getCounties() {
        return locationsService.getCounties();
    }
}
