package com.mahery.backendjavasmarttix.service.utilisateur;

import com.mahery.backendjavasmarttix.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    Utilisateur create(Utilisateur user);

    List<Utilisateur> get();

    Utilisateur edit(Long id , Utilisateur user);

    String delete(Long id);
}