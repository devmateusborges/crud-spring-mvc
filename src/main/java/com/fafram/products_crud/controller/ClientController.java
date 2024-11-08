package com.fafram.products_crud.controller;

import com.fafram.products_crud.model.Client;
import com.fafram.products_crud.service.IClientService;
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

    // Exibe a página de cadastro de cliente
    @GetMapping("/register")
    public String showRegistration() {
        return "registerClientPage";
    }

    // Salva os dados do cliente
    @PostMapping("/save")
    public String save(@ModelAttribute Client client,
                       Model model) {
        Client c = service.saveClient(client);
        String message = "Client " + c.getNome() + " saved!";  // Atualizado para mostrar o nome do cliente
        model.addAttribute("message", message);
        return "registerClientPage";
    }

    // Exibe a lista de todos os clientes
    @GetMapping("/getAllClients")
    public String getAllClients(Model model) {
        List<Client> clients = service.getAllClients();
        model.addAttribute("list", clients);
        return "listClientsPage";
    }

    // Exibe a página de edição do cliente
    @GetMapping("/edit")
    public String edit(Model model,
                       @RequestParam Long id,
                       RedirectAttributes redirectAttributes) {
        Client client = service.getClientById(id);
        model.addAttribute("client", client);
        return "editClientPage";
    }

    // Atualiza as informações do cliente
    @PostMapping("/update")
    public String update(@ModelAttribute Client client,
                         RedirectAttributes redirectAttributes) {
        service.updateClient(client);
        return "redirect:/client/getAllClients";  // Corrigido para redirecionar corretamente
    }

    // Deleta um cliente
    @GetMapping("/delete")
    public String delete(@RequestParam Long id,
                         RedirectAttributes redirectAttributes) {
        service.deleteClientById(id);
        return "redirect:/client/getAllClients";  // Corrigido para redirecionar corretamente
    }
}
