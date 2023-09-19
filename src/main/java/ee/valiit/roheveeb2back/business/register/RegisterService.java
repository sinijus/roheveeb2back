package ee.valiit.roheveeb2back.business.register;

import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
import ee.valiit.roheveeb2back.domain.company.Company;
import ee.valiit.roheveeb2back.domain.company.CompanyMapper;
import ee.valiit.roheveeb2back.domain.company.CompanyService;
import ee.valiit.roheveeb2back.business.profile.dto.NewCompany;
import ee.valiit.roheveeb2back.domain.image.Image;
import ee.valiit.roheveeb2back.domain.image.ImageService;
import ee.valiit.roheveeb2back.domain.location.Location;
import ee.valiit.roheveeb2back.domain.location.LocationMapper;
import ee.valiit.roheveeb2back.domain.location.LocationRepository;
import ee.valiit.roheveeb2back.domain.location.LocationService;
import ee.valiit.roheveeb2back.domain.location.county.County;
import ee.valiit.roheveeb2back.domain.location.county.CountyService;
import ee.valiit.roheveeb2back.domain.user.User;
import ee.valiit.roheveeb2back.domain.user.UserMapper;
import ee.valiit.roheveeb2back.domain.user.UserService;
import ee.valiit.roheveeb2back.domain.user.role.Role;
import ee.valiit.roheveeb2back.domain.user.role.RoleService;
import ee.valiit.roheveeb2back.domain.user.usercontact.UserContact;
import ee.valiit.roheveeb2back.domain.user.usercontact.UserContactMapper;
import ee.valiit.roheveeb2back.domain.user.usercontact.UserContactService;
import ee.valiit.roheveeb2back.util.ImageConverter;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class RegisterService {


    @Resource
    private UserService userService;
    @Resource
    private ImageService imageService;

    @Resource
    private RoleService roleService;
    @Resource
    private CountyService countyService;
    @Resource
    private CompanyService companyService;

    @Resource
    private LocationService locationService;
    @Resource
    private UserContactService userContactService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private UserContactMapper userContactMapper;

    private final LocationRepository locationRepository;

    public RegisterService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @Transactional
    public void registerNewCustomer(NewCustomer request) {

        // TODO: valideeri kas e-mail on hõivatud, kui jah, viska viga.
        userService.confirmEmailAvailability(request.getEmail());
        // TODO: otsi üles objekt roll (customer) roleService.getRoleCustomer()
        Role role = roleService.getRoleCustomer();
        // TODO: loo mapperi abil user objekt
        User user = userMapper.toUserCustomer(request);
        // TODO: lisa userile külge roll
        user.setRole(role);
        // TODO: salvesta user
        userService.saveUser(user);

        // TODO: otsi üles objekt county (countyId abil)
        County county = countyService.getCounty(request.getCountyId());
        // TODO: loo mapperi abil location objekt
        Location location = locationMapper.toCustomerLocation(request);
        // TODO: lisa locationile külge county
        location.setCounty(county);
        // TODO: salvesta location
        locationService.saveLocation(location);

        // TODO: loo mapperi abil userContact objekt
        UserContact userContact = userContactMapper.toUserContact(request);
        // TODO: lisa userContact külge user ja location
        userContact.setUser(user);
        userContact.setLocation(location);
        // TODO: salvesta userContact
        userContactService.saveUserContact(userContact);
    }

    public void registerNewCompany(NewCompany request) {
        userService.confirmEmailAvailability(request.getEmail());
        Role role = roleService.getRoleCompany();
        User user = userMapper.toUserCompany(request);
        user.setRole(role);
        userService.saveUser(user);

        County county = countyService.getCounty(request.getCountyId());
        Location location = locationMapper.toCompanyLocation(request);
        location.setCounty(county);
        locationService.saveLocation(location);

        Image image;
        if (request.getLogoImagedata().isEmpty()) {
            request.setLogoImagedata("");
        }
        image = ImageConverter.imageDataToImage(request.getLogoImagedata());
        imageService.saveImage(image);
        Company newCompany = companyMapper.toNewCompany(request);
        newCompany.setUser(user);
        newCompany.setLocation(location);
        newCompany.setLogoImage(image);
        companyService.saveNewCompany(newCompany);
    }
}
