package productservice.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import productservice.dto.GenericProductDto;
import productservice.models.Product;
import productservice.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SearchService {
    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public Page<GenericProductDto> searchProduct(String query, Pageable pageable){
        Page<Product> productPage = productRepository.findAllByTitleContaining(query,
                pageable);

        List<Product> products = productPage.get().collect(Collectors.toList());

        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for(Product product : products){
            genericProductDtos.add(GenericProductDto.from(product));
        }
        Page<GenericProductDto> genericProductDtoPage =
                new PageImpl<>(genericProductDtos,productPage.getPageable(),
                        productPage.getTotalElements());
        return genericProductDtoPage;
    }
}
