package com.mahery.backendjavasmarttix.service.client;

import com.mahery.backendjavasmarttix.model.Client;

import java.util.List;

public interface ClientService {

    Client create(Client user);

    List<Client> get();

    Client edit(Long id , Client user);

    String delete(Long id);
}