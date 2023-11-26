package productservice.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import productservice.dto.GenericProductDto;
import productservice.dto.SearchRequestDto;
import productservice.services.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @PostMapping
    public Page<GenericProductDto> searchProducts(@RequestBody SearchRequestDto searchRequestDto){
        return searchService.searchProduct(searchRequestDto.getQuery(),
                PageRequest.of(searchRequestDto.getPageNumber(),searchRequestDto.getSizeOfEachPage()));

    }
}
