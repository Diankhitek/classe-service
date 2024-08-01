package com.ecole221.classe.service.mapper;

import com.ecole221.classe.service.dto.ClasseDto;
import com.ecole221.classe.service.dto.FiliereDto;
import com.ecole221.classe.service.model.Classe;
import com.ecole221.classe.service.model.Filiere;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public ClasseDto classeEntityToClassDto(Classe classe) {
        return ClasseDto.builder()
                .idDto(classe.getId())
                .libelleDto(classe.getLibelle())
                .fraisInscriptionDto(classe.getFraisInscription())
                .mensualiteDto(classe.getMensualite())
                .autreFraisDto(classe.getAutreFrais())
                .filiereDto(filiereEntityToFiliereDto(classe.getFiliere()))
                .build();
    }
    public Classe classeDtoToClasseEntity(ClasseDto classeDto) {
        return Classe.builder()
                .id(classeDto.getIdDto())
                .libelle(classeDto.getLibelleDto())
                .fraisInscription(classeDto.getFraisInscriptionDto())
                .mensualite(classeDto.getMensualiteDto())
                .autreFrais(classeDto.getAutreFraisDto())
                .filiere(filiereDtoToFiliereEntity(classeDto.getFiliereDto()))
                .build();
    }
    public FiliereDto filiereEntityToFiliereDto(Filiere filiere) {
        return FiliereDto.builder().idDto(filiere.getId()).libelleDto(filiere.getLibelle()).build();
    }
    public Filiere filiereDtoToFiliereEntity(FiliereDto filiereDto) {
        return Filiere.builder().id(filiereDto.getIdDto()).libelle(filiereDto.getLibelleDto()).build();
    }
}
