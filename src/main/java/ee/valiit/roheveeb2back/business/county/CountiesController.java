package ee.valiit.roheveeb2back.business.county;

import ee.valiit.roheveeb2back.business.county.dto.CountyDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController


public class CountiesController {
    @Resource
    private CountiesService countiesService;
    @GetMapping("/counties")
    @Operation(summary = "leiab süsteemist kõik maakonnad.",
            description = """
    tagastab info koos countyId ja countyNamega
""")
    public List<CountyDto> getCounties() {
        return countiesService.getCounties();
    }
}