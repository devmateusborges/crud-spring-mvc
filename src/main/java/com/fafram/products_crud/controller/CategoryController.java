package com.fafram.products_crud.controller;

import com.fafram.products_crud.model.Category;
import com.fafram.products_crud.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @GetMapping("/register")
    public String showRegistration() {
        return "registerCategoryPage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        Category savedCategory = service.saveCategory(category);
        String message = "Categoria " + savedCategory + " salva!";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/category/getAllCategories";
    }

    @GetMapping("/getAllCategories")
    public String getAllCategories(Model model) {
        List<Category> categories = service.getAllCategories();
        model.addAttribute("list", categories);
        return "listCategoriesPage";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        Category category = service.getCategoryById(id);
        model.addAttribute("category", category);
        return "editCategoryPage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        service.updateCategory(category);
        redirectAttributes.addFlashAttribute("message", "Categoria atualizada com sucesso!");
        return "redirect:/category/getAllCategories";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        service.deleteCategoryById(id);
        redirectAttributes.addFlashAttribute("message", "Categoria deletada com sucesso!");
        return "redirect:/category/getAllCategories";
    }
}
