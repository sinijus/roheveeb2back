package ee.valiit.roheveeb2back.business.product;

import ee.valiit.roheveeb2back.domain.category.CategoryRepository;
import ee.valiit.roheveeb2back.domain.company.Company;
import ee.valiit.roheveeb2back.domain.company.CompanyRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Resource
    private CompanyRepository companyRepository;

    public Company getCompanyBy(Integer companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        return companyOptional.get();
    }
}
