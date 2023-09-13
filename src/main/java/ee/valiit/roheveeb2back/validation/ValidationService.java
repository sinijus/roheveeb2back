package ee.valiit.roheveeb2back.validation;

import ee.valiit.roheveeb2back.domain.order.Order;
import ee.valiit.roheveeb2back.domain.product.Product;
import ee.valiit.roheveeb2back.domain.product.type.Type;
import ee.valiit.roheveeb2back.domain.user.User;
import ee.valiit.roheveeb2back.infrastructure.exception.BusinessException;
import ee.valiit.roheveeb2back.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.roheveeb2back.validation.Error.*;

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

    public static void validateProductNameIsAvailable(boolean productExists) {
        if (productExists) {
            throw new BusinessException(
                    Error.PRODUCT_NAME_UNAVAILABLE.getMessage(),
                    Error.PRODUCT_NAME_UNAVAILABLE.getErrorCode());
        }
    }
    public static void validateAtLeastOneTypeExists(List<Type> types) {
        if (types.isEmpty()) {
            throw new DataNotFoundException(NO_PRODUCT_TYPE_FOUND.getMessage(), NO_PRODUCT_TYPE_FOUND.getErrorCode());
        }
    }

    public static void validateAtLeastOneOrderExists(List<Order> orders) {
        if (orders.isEmpty()) {
            throw new DataNotFoundException(NO_ORDER_FOUND.getMessage(), NO_ORDER_FOUND.getErrorCode());
        }
    }

    public static void validateCustomerEmailIsAvailable(boolean userUserEmailExists) {
        if (userUserEmailExists) {
            throw new BusinessException(
                    CUSTOMER_EMAIL_UNAVAILABLE.getMessage(),
                    CUSTOMER_EMAIL_UNAVAILABLE.getErrorCode());
        }
    }

    public static void validateAddedProductAmountExists(Integer productAmount, Integer stockBalance) {
        if (areEnoughProductsInStock(productAmount, stockBalance)) {
            throw new BusinessException(NOT_ENOUGH_PRODUCTS.getMessage(), NOT_ENOUGH_PRODUCTS.getErrorCode());
        }
    }

    private static boolean areEnoughProductsInStock(Integer productAmount, Integer stockBalance) {
        return productAmount > stockBalance;
    }
}
