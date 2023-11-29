package co.edu.cue.GallegoShop.services.impl;

import co.edu.cue.GallegoShop.domain.entities.ShoppingCart;
import co.edu.cue.GallegoShop.mapper.dtos.CartItemDto;
import co.edu.cue.GallegoShop.mapper.dtos.ShoppingCartDto;
import co.edu.cue.GallegoShop.mapper.mappers.ShoppingCartMapper;
import co.edu.cue.GallegoShop.repositories.ShoppingCartRepository;
import co.edu.cue.GallegoShop.services.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShoppinCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository repo;

    public ShoppinCartServiceImpl(ShoppingCartRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ShoppingCartDto> ShoppingCartList() {
        return ShoppingCartMapper.mapFrom((List<ShoppingCart>) repo.findAll());
    }

    @Override
    public ShoppingCartDto byId(int id) {
        return ShoppingCartMapper.mapFrom(repo.findById(id).orElseThrow());
    }

    @Override
    public ShoppingCartDto update(ShoppingCartDto shoppingCart) {
        return ShoppingCartMapper.mapFrom(
                repo.save(ShoppingCartMapper.mapFrom(shoppingCart)));
    }

    @Override
    public ShoppingCartDto save(ShoppingCartDto shoppingCart) {
        return ShoppingCartMapper.mapFrom(
                repo.save(ShoppingCartMapper.mapFrom(shoppingCart)));
    }

    @Override
    public void deleteByid(int id) {
        repo.deleteById(id);
    }

    public String getAlphaNumericString() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {

            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    @Override
    public Double total(List<CartItemDto> cartItemDtos) {
        return cartItemDtos.stream()
                .mapToDouble(x->x.product().getPrice()*x.quantity())
                .sum();
    }


    public LocalDate setOrderDate(){
        return LocalDate.now();
    }
}
