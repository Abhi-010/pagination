package productservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import productservice.dto.CategoryDto;
import productservice.dto.ProductDto;
import productservice.exception.NotFoundException;
import productservice.thirdpartyclients.FakeStoreProductDto;
import productservice.thirdpartyclients.FakeStoreProductServiceClient;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class FakeStoreProductServiceImpl implements ProductService {

    FakeStoreProductServiceClient fakeStoreProductServiceClient;
    public FakeStoreProductServiceImpl(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }
    @Override
    public ProductDto getProductById(Long id) throws NotFoundException {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.getProductById(id);

        ProductDto productDto = new ProductDto();
        productDto.setCategory(fakeStoreProductDto.getCategory());
        productDto.setTitle(fakeStoreProductDto.getTitle());
        productDto.setPrice(fakeStoreProductDto.getPrice());
        return  productDto;
    }

    @Override
    public List<ProductDto> getProductList() {

        List<FakeStoreProductDto> fakeStoreProductDtos =
                fakeStoreProductServiceClient.getProductlist();


        List<ProductDto> productDtoList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            ProductDto productDto = new ProductDto();
            productDto.setPrice(fakeStoreProductDto.getPrice());
            productDto.setTitle(fakeStoreProductDto.getTitle());
            productDto.setCategory(fakeStoreProductDto.getCategory());

            productDtoList.add(productDto);
        }

        return productDtoList;
    }


    @Override
    public List<ProductDto> getProductsByCategory(String categoryName) {

        List<FakeStoreProductDto> fakeStoreProductDtoList =
                fakeStoreProductServiceClient.getProductsByCategory(categoryName);


        List<ProductDto> productDtoList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList){
            ProductDto productDto = new ProductDto();
            productDto.setPrice(fakeStoreProductDto.getPrice());
            productDto.setTitle(fakeStoreProductDto.getTitle());
            productDto.setCategory(fakeStoreProductDto.getCategory());

            productDtoList.add(productDto);
        }

        return productDtoList;
    }
}
