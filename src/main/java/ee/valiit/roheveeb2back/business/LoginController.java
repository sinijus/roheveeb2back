package ee.valiit.roheveeb2back.business;

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
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/")
    @Operation(summary = "Sisse logimine. Tagastab userId ja roleName",
            description = """
                Süsteemist otsitakse username ja password abil kasutajat, kelle konto on ka aktiivne.
                Kui vastet ei leita visatakse viga errorCode'ga 111""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: Vale kasutajanimi või parool koos. errorCode: 111",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})


    public void login(@RequestParam String email, @RequestParam String password) {
        loginService.login(email, password);
    }
}
