package ee.valiit.roheveeb2back.business.location;

import ee.valiit.roheveeb2back.business.dto.CountyDto;
import ee.valiit.roheveeb2back.domain.county.County;
import ee.valiit.roheveeb2back.domain.county.CountyMapper;
import ee.valiit.roheveeb2back.domain.county.CountyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsService {

    @Resource
    private CountyService countyService;
    @Resource
    private CountyMapper countyMapper;
    public List<CountyDto> getCounties() {
        List<County> counties = countyService.getCounties();
        return countyMapper.toCountyDtos(counties);
    }
}
