package de.vignold.vignoldmanagement.service;

import de.vignold.vignoldmanagement.dto.ProductDTO;
import de.vignold.vignoldmanagement.entity.Product;

public interface ProductService {


    void saveProduct(Product product);
    void saveProductDTO(ProductDTO productDTO);

}
