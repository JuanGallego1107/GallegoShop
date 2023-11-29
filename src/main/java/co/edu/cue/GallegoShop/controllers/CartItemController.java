package co.edu.cue.GallegoShop.controllers;

import co.edu.cue.GallegoShop.domain.entities.CartItem;
import co.edu.cue.GallegoShop.mapper.dtos.CartItemDto;
import co.edu.cue.GallegoShop.services.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class CartItemController {
    private final CartItemService service;

    @GetMapping("/list3")
    public String listAllCartItems(Model model){
        List<CartItemDto> cartItemList = service.CartItemList();
        model.addAttribute("cartItemList", cartItemList);
        return "cartItemIndex";
    }

    @GetMapping("/new3")
    public String agregar(Model model) {
        model.addAttribute("CartItem", new CartItem());
        return "form";
    }



}
