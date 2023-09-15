package ee.valiit.roheveeb2back.business.type;

import ee.valiit.roheveeb2back.business.type.dto.TypeDto;
import ee.valiit.roheveeb2back.business.type.dto.TypeRequest;
import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TypesController {
    @Resource
    private TypesService typesService;
    @GetMapping("/types")
    @Operation(summary = " Kõikide tüüpide küsimine. Tagastab listi tüüpidest",
            description = """
                    Andmebaasist küsitakse kõigi tüüpide infot, kui ühegi tüübi infot ei leita, visatakse errorCode 555
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: Ühtegi tootetüüpi ei leitud. errorCode: 555",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<TypeDto> findAllTypes() {
        return typesService.findAllTypes();
    }

    @PostMapping("/types")
    @Operation(summary = "Uue toote tüübi lisamine",
            description = """
                    Toote tüübi lisamine, typeCategoryId ja nime alusel, kui nimi on juba olemas visatakse errorCode: 1111 
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: Sellise nimega toote tüüp on juba süsteemis olemas. errorCode: 1111",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void addNewProductType(@RequestBody @Valid TypeRequest request) {
        typesService.addNewProductType(request);

    }


}
