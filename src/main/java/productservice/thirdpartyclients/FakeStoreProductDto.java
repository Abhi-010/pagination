package productservice.thirdpartyclients;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import productservice.dto.GenericProductDto;
import productservice.models.Category;
import productservice.models.Price;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Price price;
    private Category category;
    private String description;
    private String image;
    private FakeStoreRatingDto rating ;


    public static GenericProductDto from(FakeStoreProductDto fakeStoreProductDto){

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice().getPrice());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory().getName());
        return genericProductDto;

    }
}
