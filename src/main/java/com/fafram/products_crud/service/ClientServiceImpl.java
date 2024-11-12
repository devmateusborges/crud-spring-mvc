package com.fafram.products_crud.service;

import com.fafram.products_crud.model.Client;
import com.fafram.products_crud.repository.ClientRepository;
import com.fafram.products_crud.utils.ClientNotFoundException;
import com.fafram.products_crud.utils.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository repository;

    public Client saveClient(Client client) {
        if (repository.existsByEmail(client.getEmail())) {
            throw new DuplicateEmailException("E-mail já cadastrado.");
        }
        return repository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return repository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        Optional<Client> client = repository.findById(id);
        if (client.isPresent()) {
            return client.get();
        } else {
            throw new ClientNotFoundException("Client with Id: " + id + " Not Found!");
        }
    }

    @Override
    public void updateClient(Client client) {
        repository.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        repository.delete(getClientById(id));
    }
}
