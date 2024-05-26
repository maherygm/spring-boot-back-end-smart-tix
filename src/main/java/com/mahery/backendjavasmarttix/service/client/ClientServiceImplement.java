package com.mahery.backendjavasmarttix.service.client;

import java.util.List;
import com.mahery.backendjavasmarttix.model.Client;
import com.mahery.backendjavasmarttix.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public  class ClientServiceImplement implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public Client create(Client user) {
        return clientRepository.save(user);
    }
    @Override
    public List<Client> get() {
        return clientRepository.findAll();
    }

    @Override
    public Client edit(Long id, Client user) {
        return null;
    }

    @Override
    public String delete(Long id) {
        clientRepository.deleteById(id);

        return "CLient Supprimmer";
    }


}
