package com.ecole221.classe.service.service;

import com.ecole221.classe.service.model.Classe;
import com.ecole221.classe.service.repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClasseService implements Iclasse{
    private final ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public List<Classe> findAll() {
        return classeRepository.findAll();
    }

    @Override
    public Classe save(Classe classe) {
        return classeRepository.save(classe);
    }


    public Classe findByClasse(String libelle) {
        return classeRepository.findByLibelle(libelle);
    }
}
