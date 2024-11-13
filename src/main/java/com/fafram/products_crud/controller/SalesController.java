package com.fafram.products_crud.controller;

import com.fafram.products_crud.model.Sales;
import com.fafram.products_crud.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private ISalesService salesService;

    @Autowired
    private  ISalesProductService salesProductService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IClientService clientService;


    @GetMapping("/register")
    public String showSalesProductRegistration(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("products", productService.getAllProducts());
        return "registerSalesPage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Sales sales,
                       Model model) {
        Sales s = salesService.saveSales(sales);
        String message = "Venda " + s + " salva!";
        model.addAttribute("message", message);
        return "registerSalesPage";
    }

    @GetMapping("/getAllSales")
    public String getAllSales(Model model) {
        List<Sales> sales = salesService.getAllSales();
        model.addAttribute("list", sales);
        return "listSalesPage";
    }

    @GetMapping("/edit")
    public String edit(Model model,
                       @RequestParam Long id,
                       RedirectAttributes redirectAttributes) {

        Sales sales = salesService.getSalesById(id);
        model.addAttribute("sales", sales);
        return "editSalesPage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Sales sales,
                         RedirectAttributes redirectAttributes) {
        salesService.updateSales(sales);
        return "redirect:getAllSales";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id,
                         RedirectAttributes redirectAttributes) {
        salesService.deleteSalesById(id);
        return "redirect:getAllSales";
    }
}
