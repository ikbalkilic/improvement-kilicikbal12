package de.vignold.vignoldmanagement.service;

import de.vignold.vignoldmanagement.converter.ProductToProductDTO;
import de.vignold.vignoldmanagement.dao.ProductRepository;
import de.vignold.vignoldmanagement.dto.ProductDTO;
import de.vignold.vignoldmanagement.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Product findProductById(Long id){
        return productRepository.findAllById(id);
    }
    public ProductDTO findProductDTOById(Long id){
        return ProductToProductDTO.convertToProductDto(findProductById(id));
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public List<ProductDTO> getAllProductDTO(){
        return ProductToProductDTO.convertToProductDTOList(getAllProduct());
    }

    public Product updateProduct(Long id){
        Product updateProduct=productRepository.findAllById(id);
        if (updateProduct!=null){
            updateProduct.setDeleted(Boolean.TRUE);
        }
        return productRepository.save(updateProduct);
    }
}
