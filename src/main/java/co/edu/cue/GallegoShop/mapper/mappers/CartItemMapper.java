package co.edu.cue.GallegoShop.mapper.mappers;



import co.edu.cue.GallegoShop.domain.entities.CartItem;
import co.edu.cue.GallegoShop.mapper.dtos.CartItemDto;
import co.edu.cue.GallegoShop.mapper.dtos.ProductDto;

import java.util.List;

public class CartItemMapper {
    public static CartItemDto mapFrom(CartItem source){
        return new CartItemDto(source.getId(),
                source.getProduct(),
                source.getShoppingCart(),
                source.getSize(),
                source.getQuantity()
        );
    }
    public static CartItem mapFrom(CartItemDto source){
        return new CartItem(source.cartItemId(),
                source.product(),
                source.shoppingCart(),
                source.size(),
                source.quantity()
        );
    }
    public static List<CartItemDto> mapFrom(List<CartItem> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }

}
