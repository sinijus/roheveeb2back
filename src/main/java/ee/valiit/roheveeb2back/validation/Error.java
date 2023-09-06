package ee.valiit.roheveeb2back.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    NO_LOCATION_FOUND("Ei leitud ühtegi pangaautomaati", 222),
    LOCATION_NAME_UNAVAILABLE("Sellise nimega pangaautomaadi asukoht on juba süsteemis olemas", 333);

    private final String message;
    private final int errorCode;
    Error(String message, int errorCode) {

        this.message = message;
        this.errorCode = errorCode;
    }
}
