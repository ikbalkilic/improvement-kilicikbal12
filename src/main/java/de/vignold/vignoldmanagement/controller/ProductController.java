package de.vignold.vignoldmanagement.controller;

import de.vignold.vignoldmanagement.dto.JobDTO;
import de.vignold.vignoldmanagement.dto.ProductDTO;
import de.vignold.vignoldmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<ProductDTO> findAll()
    {
        //insert your logic here and return it
        return null;
    }
    @PostMapping("/save-product")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO){
        productService.saveProductDTO(productDTO);
        return new ResponseEntity<>(null,null, HttpStatus.OK);
    }
    /*@ApiOperation(value = "Save a new prod oper output / Yeni Prod Oper Output kaydı yapar.")
    @PostMapping("/save-prod-oper-output")
    public ResponseEntity<?> saveProdOperOutput(@RequestBody ProdOperOutputDto prodOperOutputDto) {
        prodOperService.save(prodOperOutputDto);
        return new ResponseEntity<>(new ApiSuccess("Ürün Operasyon Output Başarıyla Kaydedildi", null), HttpStatus.OK);
    }*/
}
