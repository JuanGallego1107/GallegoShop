package co.edu.cue.GallegoShop.controllers;

import co.edu.cue.GallegoShop.domain.entities.CartItem;
import co.edu.cue.GallegoShop.domain.entities.Customer;
import co.edu.cue.GallegoShop.domain.entities.Product;
import co.edu.cue.GallegoShop.domain.entities.ShoppingCart;
import co.edu.cue.GallegoShop.mapper.dtos.CartItemDto;
import co.edu.cue.GallegoShop.mapper.dtos.CustomerDto;
import co.edu.cue.GallegoShop.mapper.dtos.ProductDto;
import co.edu.cue.GallegoShop.mapper.mappers.CartItemMapper;
import co.edu.cue.GallegoShop.mapper.mappers.ShoppingCartMapper;
import co.edu.cue.GallegoShop.services.CartItemService;
import co.edu.cue.GallegoShop.services.CustomerService;
import co.edu.cue.GallegoShop.services.ProductService;
import co.edu.cue.GallegoShop.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/store")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ProductService productService;
    private final CartItemService cartItemService;
    private final ShoppingCartService cartService;

    private List<CartItemDto> cartItems;

    @GetMapping("")
    public String viewCustomer(Model model){
        model.addAttribute("products", productService.ProductList());
        return "customers/customerIndex";
    }

    @GetMapping("viewProduct/{productId}")
    public String viewProduct(@PathVariable Integer productId, Model model){
        ProductDto findProduct = productService.byId(productId);
        model.addAttribute("product", findProduct);
        return "customers/viewProduct";
    }

    @PostMapping("cartItem")
    public String addItem(@RequestParam("productId") Integer productId,
                          @RequestParam("quantity") Integer quantity,
                          @RequestParam("size") String size,
                          Model model) throws Exception {
        Product productEntity = productService.byIdProduct(productId);

        ShoppingCart shoppingCart = new ShoppingCart();

        CartItem cartItemEntity = new CartItem();

        cartItemEntity.setProduct(productEntity);
        cartItemEntity.setSize(size);
        cartItemEntity.setQuantity(quantity);
        cartItemEntity.setShoppingCart(shoppingCart);

        Integer idProducto = productEntity.getId();
        boolean alreadyIn=cartItems.stream().anyMatch(x->x.product().getId()==idProducto);

        if (!alreadyIn){
            cartItems.add(CartItemMapper.mapFrom(cartItemEntity));
        }

        Double subtotal = cartService.total(cartItems);

        shoppingCart.setTotal(subtotal);


        model.addAttribute("cartItems", cartItems);
        model.addAttribute("shoppingCart", shoppingCart);

        return "shoppingCart/shoppingCartIndex";
    }

    @GetMapping("/delete/cartItem/{itemId}")
    public String deleteCartItem(@PathVariable Integer itemId, Model model){
        List<CartItemDto> newCartItems = new ArrayList<>();

        for(CartItemDto cartItem : cartItems){
            if(cartItem.product().getId() != itemId){
                newCartItems.add(cartItem);
            }
        }
        cartItems=newCartItems;


        Double subtotal = cartService.total(cartItems);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setTotal(subtotal);


        model.addAttribute("cartItems", cartItems);
        model.addAttribute("shoppingCart", shoppingCart);
        return "shoppingCart/shoppingCartIndex";
    }

    @GetMapping("/getCart")
    public String getCart(Model model){

        Double subtotal = cartService.total(cartItems);

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setTotal(subtotal);


        model.addAttribute("cartItems", cartItems);
        model.addAttribute("shoppingCart", shoppingCart);

        return "shoppingCart/shoppingCartIndex";
    }

    @GetMapping("/order")
    public String orderInfo(Model model){

        CustomerDto customer = customerService.byId(3);

        ShoppingCart cart = new ShoppingCart();
        cart.setTotal(cartService.total(cartItems));

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("customers", customer);
        model.addAttribute("shoppingCart", cart);
        return"shoppingCart/orderSummary";
    }

    @GetMapping("/saveOrder")
    public String saveOrder() throws Exception {
        Customer customer = customerService.byIdCustomer(3);

        Double subtotal = cartService.total(cartItems);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomer(customer);
        shoppingCart.setOrderDate(cartService.setOrderDate());
        shoppingCart.setCode(cartService.getAlphaNumericString());
        shoppingCart.setTotal(subtotal);

        cartService.save(ShoppingCartMapper.mapFrom(shoppingCart));

        for(CartItemDto cartItemDto: cartItems){
            CartItem cartItem = CartItemMapper.mapFrom(cartItemDto);
            cartItem.setShoppingCart(shoppingCart);
            CartItemDto cartItemDtoToSave = CartItemMapper.mapFrom(cartItem);
            cartItemService.save(cartItemDtoToSave);
        }

        return "redirect:/store";
    }

}
