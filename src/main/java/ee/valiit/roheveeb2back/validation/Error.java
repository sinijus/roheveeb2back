package ee.valiit.roheveeb2back.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    NO_LOCATION_FOUND("Ei leitud ühtegi asukohta", 444),
    NO_PRODUCT_FOUND("Ei leitud ühtegi toodet", 222),
    NO_PRODUCT_TYPE_FOUND("Ei leitud ühtegi tootetüüpi", 555),
    PRODUCT_NAME_UNAVAILABLE("Sellise nimega toode on juba süsteemis olemas", 333),
    NO_ORDER_FOUND("Ei leitud ühtegi tellimust", 666);

    private final String message;
    private final int errorCode;
    Error(String message, int errorCode) {

        this.message = message;
        this.errorCode = errorCode;
    }
}
