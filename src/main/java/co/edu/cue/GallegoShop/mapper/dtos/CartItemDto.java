package co.edu.cue.GallegoShop.mapper.dtos;


import co.edu.cue.GallegoShop.domain.entities.Product;
import co.edu.cue.GallegoShop.domain.entities.ShoppingCart;
import lombok.Builder;

@Builder
public record CartItemDto(
        Integer cartItemId,
        Product product,
        ShoppingCart shoppingCart,
        String size,
        Integer quantity
) {
}
