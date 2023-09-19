package ee.valiit.roheveeb2back.business.profile;

import ee.valiit.roheveeb2back.business.profile.dto.CompanyInfo;
import ee.valiit.roheveeb2back.business.profile.dto.UserContactInfo;
import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {
    @Resource
    private ProfileService profileService;


    @GetMapping("/profile/customer")
    @Operation(summary = "Kasutaja profiili andmete kuvamine",
            description = """
                    Süsteemist otsitakse userId alusel järgmised andmed: eesnimi, perenimi, email, telefon,
                    aadress, linn/alevik/küla, postiindeks.""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: andmeid ei leitud. errorCode: ???",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public UserContactInfo getUserContactInfo(@RequestParam Integer userId) {
        return profileService.getUserContactInfo(userId);
    }

    @GetMapping("/profile/company")
    @Operation(summary = "Company profile andmete otsimine companyID alusel läbi company tabeli.",
            description = "Company profile andmete otsimine companyID alusel läbi company tabeli.")
    public CompanyInfo getCompanyInfo(@RequestParam Integer companyId) {
        return profileService.getCompanyInfo(companyId);
    }



    @PutMapping("/profile/customer")
    @Operation(summary = "Kasutaja profiili andmete uuendamine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise e-mailiga kasutaja on meie süsteemis juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void updateCustomerProfile(@RequestParam Integer userId, @RequestBody UpdatedCustomerProfile request) {
        profileService.updateCustomerProfile(userId, request);
    }




}
