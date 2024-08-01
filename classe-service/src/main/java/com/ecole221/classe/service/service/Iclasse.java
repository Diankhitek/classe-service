package com.ecole221.classe.service.service;



import com.ecole221.classe.service.model.Classe;

import java.util.List;

public interface Iclasse {
    public List<Classe> findAll();

    public Classe save(Classe classe);

    public Classe findByClasse(String libelle);
}
