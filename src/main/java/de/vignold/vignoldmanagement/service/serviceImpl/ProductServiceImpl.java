package de.vignold.vignoldmanagement.service.serviceImpl;
import de.vignold.vignoldmanagement.converter.ProductToProductDTO;
import de.vignold.vignoldmanagement.dao.ProductRepository;
import de.vignold.vignoldmanagement.dto.ProductDTO;
import de.vignold.vignoldmanagement.entity.Product;
import de.vignold.vignoldmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void saveProductDTO(ProductDTO productDTO) {
        saveProduct(ProductToProductDTO.convertToProduct(productDTO));

    }
}
