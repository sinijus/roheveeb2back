package ee.valiit.roheveeb2back.domain.company;

import ee.valiit.roheveeb2back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Resource
    private CompanyRepository companyRepository;

    public Company getCompanyByCompanyId(Integer companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        return companyOptional.get();
    }

    public Company saveNewCompany(Company newCompany) {
        return companyRepository.save(newCompany);
    }

    public Company getCompanyInfo(Integer companyId) {
        return companyRepository.findById(companyId).get();

    }

    public Company getCompanyByUserId(Integer userId) {
        return companyRepository.getCompanyBy(userId);
    }
    public Company findCompanyByUserId(Integer userId) {
        Optional<Company> companyOptional = companyRepository.findCompanyBy(userId);
        ValidationService.validateCompanyExists(companyOptional);
        return companyOptional.get();
    }
}
