package de.vignold.vignoldmanagement.controller;


import de.vignold.vignoldmanagement.dto.ProductDTO;
import de.vignold.vignoldmanagement.entity.Product;
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

 /*   @GetMapping("/all")
    public List<ProductDTO> findAll()
    {
        //insert your logic here and return it
        return null;
    }*/
    @PostMapping("/save-product")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO){
        productService.saveProductDTO(productDTO);
        return new ResponseEntity<>(null,null, HttpStatus.OK);
    }

    @GetMapping("/find-all-product")
    public ResponseEntity<?> findAll()
    {
        List<ProductDTO> productDTOList=productService.getAllProductDTO();
        return new ResponseEntity<List<ProductDTO>>(productDTOList, HttpStatus.OK);
    }

    @GetMapping("/find-product-by-id/{id}")
    public ResponseEntity<?> findByProduct(@PathVariable("id") Long id){
        ProductDTO productDTO=productService.findProductDTOById(id);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/update-product/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable("id") Long id){
        Product product=productService.updateProduct(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

}
