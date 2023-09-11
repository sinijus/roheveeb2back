package ee.valiit.roheveeb2back.business;

import ee.valiit.roheveeb2back.business.dto.ProductDto;
import ee.valiit.roheveeb2back.business.dto.ProductInfoDto;
import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @GetMapping("/product")
    @Operation(summary = " Kõikide toodete küsimine. Tagastab listi toodetest, mis on aktiivse staatusega ",
            description = """
                    Andmebaasist küsitakse kõigi toodete infot, kui toodete infot ei leita visatakse errorCode 222
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "message: Ühtegi toodet ei leitud. errorCode: 222",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<ProductInfoDto> findAllProducts() {
        return productsService.findAllProducts();
    }

    @PostMapping("/product?")
    @Operation(summary = "Uue toote lisamine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega toode on poes juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addNewProduct(@RequestBody ProductDto request) {
        productsService.addNewProduct(request);
    }
}
