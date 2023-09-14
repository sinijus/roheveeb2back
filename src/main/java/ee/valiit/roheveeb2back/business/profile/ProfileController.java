package ee.valiit.roheveeb2back.business.profile;

import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    @Resource
    private ProfileService profileService;
    @PutMapping("/profile/customer")
    @Operation(summary = "kasutaja profiili uuendamine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise e-mailiga kasutaja on meie süsteemis juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })

public void updateCustomerProfile(@RequestParam Integer userId, @RequestBody UpdatedCustomerProfile request) {
        profileService.updateCustomerProfile(userId, request);
    }


}
