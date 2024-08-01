package com.ecole221.classe.service.repository;

import com.ecole221.classe.service.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    public Classe findByLibelle(String libelle);
}
