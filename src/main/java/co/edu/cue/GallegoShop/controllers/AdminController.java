package co.edu.cue.GallegoShop.controllers;

import co.edu.cue.GallegoShop.mapper.dtos.AdminDto;
import co.edu.cue.GallegoShop.mapper.dtos.ProductDto;
import co.edu.cue.GallegoShop.services.AdminService;
import co.edu.cue.GallegoShop.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final ProductService service;

    @GetMapping("")
    public String adminView(Model model){
        List<ProductDto> productsList = service.ProductList();
        model.addAttribute("products", productsList);
        return "admin/adminIndex";
    }

    @GetMapping("/sign_up")
    public String signUpView(){
        return "admin/signup";
    }

}
