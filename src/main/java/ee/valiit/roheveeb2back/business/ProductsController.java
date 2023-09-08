package ee.valiit.roheveeb2back.business;

import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @GetMapping("/product")
    @Operation(summary = " Kõikide toodete küsimine. Tagastab listi toote objektidega, kus on väljad ",
            description = """
                    Andmebaasist küsitakse kõigi toodete infot, kui toodete infot ei leita visatakse errorCode ???
                    """)
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: Vale kasutajanimi või parool koos. errorCode: 111",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void findAllProducts() {
        productsService.findAllProducts();
    }
}
