package de.vignold.vignoldmanagement.converter;

import de.vignold.vignoldmanagement.dto.JobDTO;
import de.vignold.vignoldmanagement.dto.ProductDTO;
import de.vignold.vignoldmanagement.entity.Job;
import de.vignold.vignoldmanagement.entity.Product;
import de.vignold.vignoldmanagement.entity.state.State;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductToProductDTO {
    public static Product convertToProduct(ProductDTO productDTO){
        Product product = new Product();
        //BeanUtils.copyProperties();

        product.setId(productDTO.getId());
        if (productDTO.getJobDTO() !=null) {
            product.setJob(Job.builder().id(productDTO.getJobDTO().getId()).build());
            //productDTO.setJobDTO(CompanyConverter.convertToCompanyDto(product.getCompany()));
        }
        product.setDescription(productDTO.getDescription());
        product.setDeleted(productDTO.getDeleted());
        //product.setState(State.RUNNING);
        product.setCreatedDate(productDTO.getCreatedDate());
        product.setUpdatedDate(productDTO.getUpdatedDate());
        product.setOperatorId(productDTO.getOperatorId());




        return product;
    }

    public static ProductDTO convertToProductDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        //BeanUtils.copyProperties();

            productDTO.setId(product.getId());
            if (product.getJob() !=null) {
                productDTO.setJobDTO(JobDTO.builder().id(product.getJob().getId()).build());
                //productDTO.setJobDTO(CompanyConverter.convertToCompanyDto(product.getCompany()));
            }
            productDTO.setDescription(product.getDescription());
            productDTO.setDeleted(product.getDeleted());
            productDTO.setState(State.RUNNING);
            productDTO.setCreatedDate(product.getCreatedDate());
            productDTO.setUpdatedDate(product.getUpdatedDate());
            productDTO.setOperatorId(product.getOperatorId());




        return productDTO;
    }

    public static List<ProductDTO> convertToProductDTOList(List<Product> productList){
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product item : productList){
            productDTOList.add(convertToProductDto(item));
        }
        return productDTOList;
    }
}
