package co.edu.cue.GallegoShop.services.impl;

import co.edu.cue.GallegoShop.domain.entities.CartItem;
import co.edu.cue.GallegoShop.domain.entities.Product;
import co.edu.cue.GallegoShop.mapper.dtos.CartItemDto;
import co.edu.cue.GallegoShop.mapper.mappers.CartItemMapper;
import co.edu.cue.GallegoShop.mapper.mappers.ProductMapper;
import co.edu.cue.GallegoShop.repositories.CartItemRepository;
import co.edu.cue.GallegoShop.services.CartItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository repo;

    public CartItemServiceImpl(CartItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CartItemDto> CartItemList() {
       return CartItemMapper.mapFrom((List<CartItem>)repo.findAll());
    }

    @Override
    public CartItemDto save(CartItemDto cartItem) {
        return CartItemMapper.mapFrom(
                repo.save(CartItemMapper.mapFrom(cartItem)));
    }

    @Override
    public CartItemDto byId(int id) {
        return CartItemMapper.mapFrom(repo.findById(id).orElseThrow());
    }

    @Override
    public CartItemDto update(CartItemDto cartItem) {
      return CartItemMapper.mapFrom(repo.save(CartItemMapper.mapFrom(cartItem)));
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }


}
