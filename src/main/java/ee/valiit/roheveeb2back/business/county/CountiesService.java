package ee.valiit.roheveeb2back.business.county;

import ee.valiit.roheveeb2back.business.county.dto.CountyDto;
import ee.valiit.roheveeb2back.domain.location.county.County;
import ee.valiit.roheveeb2back.domain.location.county.CountyMapper;
import ee.valiit.roheveeb2back.domain.location.county.CountyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountiesService {

    @Resource
    private CountyService countyService;
    @Resource
    private CountyMapper countyMapper;

    public List<CountyDto> getCounties() {
        List<County> counties = countyService.getCounties();
        return countyMapper.toCountyDtos(counties);
    }
}
