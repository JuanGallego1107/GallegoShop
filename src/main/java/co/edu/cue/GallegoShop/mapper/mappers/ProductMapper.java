package co.edu.cue.GallegoShop.mapper.mappers;



import co.edu.cue.GallegoShop.domain.entities.Product;
import co.edu.cue.GallegoShop.mapper.dtos.ProductDto;

import java.util.List;

public class ProductMapper {
    public static ProductDto mapFrom(Product source){
        return new ProductDto(source.getId(),
                source.getProductName(),
                source.getDescription(),
                source.getPrice(),
                source.getStock(),
                source.getCategory(),
                source.getImageUrl()
        );
    }
    public static Product mapFrom(ProductDto source){
        return new Product(source.productId(),
                source.productName(),
                source.description(),
                source.price(),
                source.stock(),
                source.category(),
                source.image()
        );
    }
    public static List<ProductDto> mapFrom(List<Product> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
