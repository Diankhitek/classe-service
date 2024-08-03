package com.ecole221.classe.service.service;


import com.ecole221.classe.service.exception.ClasseServiceNotFoundException;
import com.ecole221.classe.service.mapper.Mapper;
import com.ecole221.classe.service.model.Classe;
import com.ecole221.classe.service.repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClasseService implements Iclasse {
    private final ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository, Mapper mapper) {
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

    @Override
    public Classe findByClasse(String libelle) {
        return classeRepository.findByLibelle(libelle);
    }

    @Override
    public Classe findById(long id) {
        //s'il retrouve il le retourne sinon il retourne un null
        return classeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Classe classe) {
        classeRepository.delete(classe);
    }

    @Override
    public Classe updateClasseById(long id, Classe classe) {
        return classeRepository.findById(id)
                .map(classeExistante -> {
                    classeExistante.setAutreFrais(classe.getAutreFrais());
                    classeExistante.setFiliere(classe.getFiliere());
                    classeExistante.setMensualite(classe.getMensualite());
                    classeExistante.setFraisInscription(classe.getFraisInscription());
                    return classeRepository.save(classeExistante);
                })
                .orElseThrow(() -> new ClasseServiceNotFoundException("La classe d'id " + id + " n'existe pas"));
    }

}