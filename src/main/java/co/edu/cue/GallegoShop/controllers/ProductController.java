package co.edu.cue.GallegoShop.controllers;

import co.edu.cue.GallegoShop.domain.entities.Product;
import co.edu.cue.GallegoShop.mapper.dtos.ProductDto;
import co.edu.cue.GallegoShop.services.ProductService;
import co.edu.cue.GallegoShop.services.impl.UploadImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/admin/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService service;
    private final UploadImageService imageService;

    @GetMapping("")
    public String showProducts(Model model) {
        List<ProductDto> productList = service.ProductList();
        model.addAttribute("productList", productList);
        return "products/productIndex";
    }

    @GetMapping("/createProduct")
    public String createProduct(){
        return "products/createProduct";
    }

    @PostMapping("/update")
    public String updateProduct(ProductDto product, @RequestParam("img") MultipartFile file) throws IOException {
        /*if (product.productId()==null) {
            String imgName= imageService.saveImage(file);

        }
         */
        service.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/editProduct/{productId}")
    public String editProduct(@PathVariable Integer productId, Model model) {
        ProductDto productToEdit = service.byId(productId);

        if (productToEdit != null) {
            model.addAttribute("productToEdit", productToEdit);
            return "products/editProduct";
        } else {
            return "products/editProduct";
        }
    }

    @PostMapping("/saveEditedProduct")
    public String saveEditedProduct(@ModelAttribute("productToEdit") ProductDto editedProduct,
                                    @RequestParam("img") MultipartFile file) throws Exception {

        Product product = new Product();
        ProductDto p =service.byId(editedProduct.productId());

        /*
        if (file.isEmpty()) {
            product.setImageUrl(p.image());
        }else {
            if (!p.image().equals("default.jpg")) {
                imageService.deleteImage(p.image());
            }
            String imgName = imageService.saveImage(file);

        }
        */

        service.update(editedProduct);
        return "redirect:/admin/products";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String delete(@PathVariable Integer productId) {
        /*ProductDto p ;
        p=service.byId(productId);

        if (!p.image().equals("default.jpg")) {
            imageService.deleteImage(p.image());
        }*/
        service.deleteById(productId);
        return "redirect:/admin/products";
    }

}
