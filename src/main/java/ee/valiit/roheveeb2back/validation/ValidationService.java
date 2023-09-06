package ee.valiit.roheveeb2back.validation;

import ee.valiit.roheveeb2back.domain.user.User;
import ee.valiit.roheveeb2back.infrastructure.exception.BusinessException;

import java.util.Optional;

import static ee.valiit.roheveeb2back.validation.Error.INCORRECT_CREDENTIALS;

public class ValidationService {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }
}
