package com.mahery.backendjavasmarttix.controller;

import com.mahery.backendjavasmarttix.service.utilisateur.UtilisateurService;
import com.mahery.backendjavasmarttix.model.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateur")
@AllArgsConstructor
public class UtilisateurController {
    private final UtilisateurService utilisateurService;
    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur user){
        Utilisateur utilisateur = utilisateurService.create(user);
        return utilisateur;
    }
    @GetMapping
    public List<Utilisateur> getAll(){
        List<Utilisateur> user = utilisateurService.get();
        return user;
    }
    @DeleteMapping({"{id}"})
    public String delete(@PathVariable Long id){
        return utilisateurService.delete(id);
    }
}
