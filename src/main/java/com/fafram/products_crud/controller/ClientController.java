package com.fafram.products_crud.controller;

import com.fafram.products_crud.model.Client;
import com.fafram.products_crud.service.IClientService;
import com.fafram.products_crud.utils.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService service;

    @GetMapping("/register")
    public String showRegistration() {
        return "registerClientPage";
    }

    // Salva os dados do cliente
    @PostMapping("/save")
    public String save(@ModelAttribute Client client,
                       Model model) {
        try {
            Client c = service.saveClient(client);
            String message = "Cliente " + c.getName() + " foi salvo com sucesso!";
            model.addAttribute("message", message);
            return "registerClientPage";
        } catch (DuplicateEmailException e) {
            model.addAttribute("error", "Este e-mail já está cadastrado!");
            return "registerClientPage";
        }
    }

    @GetMapping("/getAllClients")
    public String getAllClients(Model model) {
        List<Client> clients = service.getAllClients();
        model.addAttribute("list", clients);
        return "listClientsPage";
    }

    @GetMapping("/edit")
    public String edit(Model model,
                       @RequestParam Long id) {
        Client client = service.getClientById(id);
        model.addAttribute("client", client);
        return "editClientPage";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Client client,
                         Model model) {
        try {
            service.updateClient(client);
            return "redirect:/client/getAllClients";
        } catch (DuplicateEmailException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("client", client);
            return "editClientPage";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        service.deleteClientById(id);
        return "redirect:/client/getAllClients";
    }
}
