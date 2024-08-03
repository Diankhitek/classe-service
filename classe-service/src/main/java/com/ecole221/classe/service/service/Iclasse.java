package com.ecole221.classe.service.service;

import com.ecole221.classe.service.model.Classe;

import java.util.List;

public interface Iclasse {
    List<Classe> findAll();

    Classe save(Classe classe);

    Classe findByClasse(String libelle);

    Classe findById(long id);

    void remove(Classe classe);

    Classe updateClasseById(long id,Classe classe);


}
