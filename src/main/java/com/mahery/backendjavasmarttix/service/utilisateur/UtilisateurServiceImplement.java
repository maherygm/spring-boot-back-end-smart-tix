package com.mahery.backendjavasmarttix.service.utilisateur;


import java.util.List;
import com.mahery.backendjavasmarttix.model.Utilisateur;
import com.mahery.backendjavasmarttix.repository.UtilisateurRepository;
import com.mahery.backendjavasmarttix.service.utilisateur.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public  class UtilisateurServiceImplement implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur create(Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    @Override
    public List<Utilisateur> get() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur edit(Long id, Utilisateur user) {
        return null;
    }

    @Override
    public String delete(Long id) {
         utilisateurRepository.deleteById(id);
        return "Utilisateur Supprimmer";
    }


}
