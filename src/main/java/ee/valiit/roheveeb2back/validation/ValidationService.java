package ee.valiit.roheveeb2back.validation;

import ee.valiit.roheveeb2back.domain.product.Product;
import ee.valiit.roheveeb2back.domain.user.User;
import ee.valiit.roheveeb2back.infrastructure.exception.BusinessException;
import ee.valiit.roheveeb2back.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.roheveeb2back.validation.Error.INCORRECT_CREDENTIALS;
import static ee.valiit.roheveeb2back.validation.Error.NO_PRODUCT_FOUND;

public class ValidationService {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void validateAtLeastOneProductExists(List<Product> products) {
        if (products.isEmpty()) {
            throw new DataNotFoundException(NO_PRODUCT_FOUND.getMessage(), NO_PRODUCT_FOUND.getErrorCode());
        }
    }
}
