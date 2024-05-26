package com.mahery.backendjavasmarttix.repository;

import com.mahery.backendjavasmarttix.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}