package ee.valiit.roheveeb2back.domain.company;

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

    public Company saveNewCompany(Company newCompany) {
        return companyRepository.save(newCompany);

    }
}
