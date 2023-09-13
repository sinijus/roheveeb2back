package ee.valiit.roheveeb2back.domain.usercontact;

import ee.valiit.roheveeb2back.domain.LocationRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserContactService {

    @Resource
    private UserContactRepository userContactRepository;
    private final LocationRepository locationRepository;

    public UserContactService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public UserContact getUserContactInfoBy(Integer userId) {
        UserContact userContact = userContactRepository.getUserContactInfoBy(userId);
        return userContact;
    }
}
