package productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import productservice.models.Category;
import productservice.models.Price;
import productservice.models.Product;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericProductDto {
    private Long id;
    private String title;
    private String category;
    private String description;
    private double price;
    private String image;


    public static GenericProductDto from(Product product){
        return new GenericProductDto(product.getId(), product.getTitle(),
                product.getCategory().getName(), product.getDescription(),
                product.getPrice().getPrice(),product.getImage());
    }
}
