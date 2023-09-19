package ee.valiit.roheveeb2back.business.register;

import ee.valiit.roheveeb2back.business.register.dto.NewCustomer;
import ee.valiit.roheveeb2back.business.profile.dto.NewCompany;
import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @PostMapping("/register/customer")
    @Operation(summary = "Uue kasutaja lisamine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise e-mailiga kasutaja on meie süsteemis juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void registerNewCustomer(@RequestBody @Valid NewCustomer request) {
        registerService.registerNewCustomer(request);
    }
    @PostMapping("/register/company")
    @Operation(summary = "Uue müüja lisamine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise e-mailiga müüja on meie süsteemis juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void RegisterNewCompany(@RequestBody @Valid NewCompany request) {
        registerService.registerNewCompany(request);
    }
}
