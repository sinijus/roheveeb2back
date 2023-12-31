package ee.valiit.roheveeb2back.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    NO_LOCATION_FOUND("Ei leitud ühtegi asukohta", 444),
    NO_PRODUCT_FOUND("Ei leitud ühtegi toodet", 222),
    NO_PRODUCT_TYPE_FOUND("Ei leitud ühtegi tootetüüpi", 555),
    PRODUCT_NAME_UNAVAILABLE("Sellise nimega toode on juba süsteemis olemas", 333),
    PRODUCT_TYPE_NAME_UNAVAILABLE("Sellise nimega toote tüüp on juba süsteemis olemas", 1111),
    NO_ORDER_FOUND("Ei leitud ühtegi tellimust", 666),
    NOT_ENOUGH_PRODUCTS("Selline toote kogus ei ole enam saadaval", 777),
    EMAIL_UNAVAILABLE("Sellise emailiga kasutaja on meie süsteemis juba olemas", 777),
    ILLEGAL_INPUT("Illegaalne sisend", 999),
    NO_ORDER_PRODUCT_FOUND("Ostukorvis ei leitud ühtegi lisatud toodet", 2222),
    NO_COMPANY_FOUND("Company id-d ei leitud", 3333);



    private final String message;
    private final int errorCode;
    Error(String message, int errorCode) {

        this.message = message;
        this.errorCode = errorCode;
    }
}
