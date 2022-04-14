package de.vignold.vignoldmanagement.service;

import de.vignold.vignoldmanagement.converter.ProductToProductDTO;
import de.vignold.vignoldmanagement.dao.ProductRepository;
import de.vignold.vignoldmanagement.dto.ProductDTO;
import de.vignold.vignoldmanagement.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void saveProduct(Product product){
        productRepository.save(product);
    }
    public void saveProductDTO(ProductDTO productDTO){
        saveProduct(ProductToProductDTO.convertToProduct(productDTO));
    }

}
