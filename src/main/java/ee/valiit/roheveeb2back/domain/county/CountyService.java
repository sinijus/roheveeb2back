package ee.valiit.roheveeb2back.domain.county;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    @Resource
    private CountyRepository countyRepository;

    public List<County> getCounties() {
        return countyRepository.findAll();
    }
}
