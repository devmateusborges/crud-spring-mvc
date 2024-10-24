package com.fafram.products_crud.controller;

import com.fafram.products_crud.model.Product;
import com.fafram.products_crud.service.IProductService;
import com.fafram.products_crud.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping("/register")
    public String showRegistration() {
        return "registerProductPage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product,
                              Model model) {
        Product p = service.saveProduct(product);
        String message = "Produto " + p.getName() + " salvo!";
        model.addAttribute("message", message);
        return "registerProductPage";
    }

    @GetMapping("/getAllProducts")
    public String getAllProducts(Model model) {
        List<Product> products = service.getAllProducts();
        model.addAttribute("list", products);
        return "listProductsPage";
    }

    @GetMapping("/edit")
    public String edit(Model model,
                       @RequestParam Long id,
                       RedirectAttributes redirectAttributes) {

        Product product = service.getProductById(id);
        model.addAttribute("product", product);
        return "editProductPage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {
        service.updateProduct(product);
        return "redirect:getAllProducts";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id,
                         RedirectAttributes redirectAttributes) {
        service.deleteProductById(id);
        return "redirect:getAllProducts";
    }
}
