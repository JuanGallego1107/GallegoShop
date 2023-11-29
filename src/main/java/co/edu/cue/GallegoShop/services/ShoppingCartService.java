package co.edu.cue.GallegoShop.services;

import co.edu.cue.GallegoShop.mapper.dtos.CartItemDto;
import co.edu.cue.GallegoShop.mapper.dtos.ShoppingCartDto;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCartDto> ShoppingCartList();
    ShoppingCartDto byId(int id);
    ShoppingCartDto update(ShoppingCartDto shoppingCart);
    ShoppingCartDto save(ShoppingCartDto shoppingCart);
    void deleteByid(int id);
    LocalDate setOrderDate();
    String getAlphaNumericString();
    Double total(List<CartItemDto> cartItemDtos);
}
