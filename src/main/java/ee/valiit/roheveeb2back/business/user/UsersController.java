package ee.valiit.roheveeb2back.business.user;

import ee.valiit.roheveeb2back.business.user.dto.CompanyInfo;
import ee.valiit.roheveeb2back.business.user.dto.UserContactInfo;
import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @GetMapping("/profile/user")
    @Operation(summary = "User profile andmete otsimine userID alusel läbi contact tabeli.",
            description = """
                    Süsteemist otsitakse userId alusel järgmised andmed: eesnimi, perenimi, email, telefon,
                    aadress, linn/alevik/küla, postiindeks.""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: andmeid ei leitud. errorCode: ???",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public UserContactInfo getUserContactInfo(@RequestParam Integer userId) {
        return usersService.getUserContactInfo(userId);
    }

    @GetMapping("/profile/company")
    @Operation(summary = "Company profile andmete otsimine companyID alusel läbi company tabeli.",
            description = "Company profile andmete otsimine companyID alusel läbi company tabeli.")
    public CompanyInfo getCompanyInfo(@RequestParam Integer companyId) {
        return usersService.getCompanyInfo(companyId);
    }



}
