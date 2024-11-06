package com.fafram.products_crud.service;

import com.fafram.products_crud.model.Client;

import java.util.List;

public interface IClientService {

    public Client saveClient(Client client);

    public List<Client> getAllClients();

    public Client getClientById(Long id);

    public void updateClient(Client client);

    public void deleteClientById(Long id);
}
