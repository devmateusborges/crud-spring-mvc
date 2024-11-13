package com.fafram.products_crud.controller;

import com.fafram.products_crud.model.Product;
import com.fafram.products_crud.model.Category;
import com.fafram.products_crud.service.ICategoryService;
import com.fafram.products_crud.service.IProductService;
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
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/register")
    public String showRegistration(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());
        return "registerProductPage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        Product savedProduct = productService.saveProduct(product);
        String message = "Produto " + savedProduct + " salvo com sucesso!";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/product/register";
    }

    @GetMapping("/getAllProducts")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("list", products);
        return "listProductsPage";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model, RedirectAttributes redirectAttributes) {
        Product product = productService.getProductById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("error", "Produto não encontrado!");
            return "redirect:/product/getAllProducts";
        }
        model.addAttribute("product", product);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "editProductPage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("message", "Produto atualizado com sucesso!");
        return "redirect:/product/getAllProducts";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        productService.deleteProductById(id);
        redirectAttributes.addFlashAttribute("message", "Produto deletado com sucesso!");
        return "redirect:/product/getAllProducts";
    }
}
