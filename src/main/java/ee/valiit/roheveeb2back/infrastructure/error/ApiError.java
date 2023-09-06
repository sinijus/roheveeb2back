package ee.valiit.roheveeb2back.infrastructure.error;

import lombok.Data;
@Data
public class ApiError {
    private String message;
    private Integer errorCode;
}