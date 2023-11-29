package co.edu.cue.GallegoShop.services;


import co.edu.cue.GallegoShop.domain.entities.CartItem;
import co.edu.cue.GallegoShop.mapper.dtos.CartItemDto;

import java.util.List;

public interface CartItemService {
    List<CartItemDto> CartItemList();
    CartItemDto byId(int id);
    CartItemDto save(CartItemDto cartItem);
    CartItemDto update(CartItemDto cartItem);
    void deleteById(int id);
}
