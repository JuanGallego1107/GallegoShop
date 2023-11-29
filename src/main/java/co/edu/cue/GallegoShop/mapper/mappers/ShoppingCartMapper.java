package co.edu.cue.GallegoShop.mapper.mappers;



import co.edu.cue.GallegoShop.domain.entities.ShoppingCart;
import co.edu.cue.GallegoShop.mapper.dtos.ShoppingCartDto;

import java.util.List;

public class ShoppingCartMapper {
    public static ShoppingCartDto mapFrom(ShoppingCart source){
        return new ShoppingCartDto(source.getId(),
                source.getCode(),
                source.getItems(),
                source.getCustomer(),
                source.getOrderDate(),
                source.getTotal());
    }
    public static ShoppingCart mapFrom(ShoppingCartDto source){
        return new ShoppingCart(source.cartId(),
                source.code(),
                source.item(),
                source.customer(),
                source.orderDate(),
                source.total());
    }
    public static List<ShoppingCartDto> mapFrom(List<ShoppingCart> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
