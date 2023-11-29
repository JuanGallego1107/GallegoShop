package co.edu.cue.GallegoShop.mapper.dtos;

import co.edu.cue.GallegoShop.domain.entities.CartItem;
import co.edu.cue.GallegoShop.domain.entities.Customer;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ShoppingCartDto(
        Integer cartId,
        String code,
        List<CartItem> item,
        Customer customer,
        LocalDate orderDate,
        Double total
) {
    public static ShoppingCartDtoBuilder builder() {
        return new ShoppingCartDtoBuilder();
    }
}
