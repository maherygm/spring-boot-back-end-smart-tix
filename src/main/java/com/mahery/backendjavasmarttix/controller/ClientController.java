package com.mahery.backendjavasmarttix.controller;

import com.mahery.backendjavasmarttix.model.Client;
import com.mahery.backendjavasmarttix.service.client.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping
    public Client create(@RequestBody Client user){
        Client client = clientService.create(user);
        return client;
    }
    @GetMapping
    public List<Client> getAll(){
        List<Client> user = clientService.get();
        return user;
    }
    @DeleteMapping({"{id}"})
    public String delete(@PathVariable Long id){
        return clientService.delete(id);
    }
}
