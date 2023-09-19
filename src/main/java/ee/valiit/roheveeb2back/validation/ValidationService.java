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

    public static void validateEmailIsAvailable(boolean emailExists) {
        if (emailExists) {
            throw new BusinessException(EMAIL_UNAVAILABLE.getMessage(),EMAIL_UNAVAILABLE.getErrorCode());
        }
    }



    public static void calculateAndValidateAddedProductAmountExists(Integer orderProductQuantity, Integer requestToAdd, Integer productStockBalance) {
        if (isThereEnoughProductsInStock(orderProductQuantity, requestToAdd, productStockBalance)) {
            int availableAmount = productStockBalance - orderProductQuantity;
            throw new BusinessException(NOT_ENOUGH_PRODUCTS.getMessage() + availableAmount, NOT_ENOUGH_PRODUCTS.getErrorCode());
        }
    }

    private static boolean isThereEnoughProductsInStock(Integer orderProductQuantity, Integer requestToAdd, Integer productStockBalance) {
        return orderProductQuantity + requestToAdd > productStockBalance;
    }

    public static void validateChangeInQuantity(Integer quantity, Integer changeInQuantity, Integer stockBalance) {
        if (changeInQuantityLessThanOneOrBiggerThanStockBalance(quantity, changeInQuantity, stockBalance)) {
            throw new IllegalArgumentException(ILLEGAL_INPUT.getMessage());
        }
    }
    private static boolean changeInQuantityLessThanOneOrBiggerThanStockBalance(Integer quantity,
                                                                               Integer changeInQuantity,
                                                                               Integer stockBalance) {
        return quantity + changeInQuantity <= 0 && quantity + changeInQuantity > stockBalance;
    }

    public static void validateTypeNameIsAvailable(boolean typeNameExists) {
        if (typeNameExists) {
            throw new BusinessException(
                    PRODUCT_TYPE_NAME_UNAVAILABLE.getMessage(),
                    PRODUCT_TYPE_NAME_UNAVAILABLE.getErrorCode());
        }
    }
}
