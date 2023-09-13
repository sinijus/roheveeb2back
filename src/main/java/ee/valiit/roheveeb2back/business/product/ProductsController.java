package ee.valiit.roheveeb2back.business.product;

import ee.valiit.roheveeb2back.business.dto.*;
import ee.valiit.roheveeb2back.business.product.dto.NewProduct;
import ee.valiit.roheveeb2back.business.product.dto.ProductInfoDto;
import ee.valiit.roheveeb2back.business.product.dto.UpdatedProduct;
import ee.valiit.roheveeb2back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @GetMapping("/products")
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


    // TODO: 9/13/2023 Ümber tõsta

    @GetMapping("/measureunits")
    @Operation(summary = "Kõikide ühikute küsimine. Tagastab kõik ühikud",
            description = """
            Kõikide ühikute küsimine. Tagastab kõik ühikud
            """)

    public List<MeasureUnitDto> getMeasureUnits() {
        return productsService.getMeasureUnits();
    }


    // TODO: 9/13/2023  Ümber tõsta
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
        return productsService.findAllTypes();
    }

    @PostMapping("/product")
    @Operation(summary = "Uue toote lisamine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega toode on poes juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addNewProduct(@RequestBody @Valid NewProduct request) {
        productsService.addNewProduct(request);
    }

    @PutMapping("/product")
    public void updateProductInfo(@RequestParam Integer productId  ,@RequestBody UpdatedProduct request) {
        productsService.updateProductInfo(productId, request);
    }

    @DeleteMapping("/product")
    @Operation(summary = "Eemaldab toote info müüja poe vaates",
            description = """
                    Muudab ära asukoha staatuse active --> deleted
                    """)
    public void deleteProduct(@RequestParam Integer productId) {
        productsService.deleteProduct(productId);
    }



}
