package co.edu.cue.GallegoShop.controllers;

import co.edu.cue.GallegoShop.domain.entities.ShoppingCart;
import co.edu.cue.GallegoShop.mapper.dtos.ShoppingCartDto;
import co.edu.cue.GallegoShop.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService cartService;

    @GetMapping("/list2")
    public String listAllShoppingCarts(Model model){
        List<ShoppingCartDto> shoppingCartList = cartService.ShoppingCartList();
        model.addAttribute("shoppingCartList", shoppingCartList);
        return "shoppingCartIndex2";
    }

    @GetMapping("/new2")
    public String agregar(Model model) {
        model.addAttribute("shoppingCart", new ShoppingCart());
        return "form";
    }

}
