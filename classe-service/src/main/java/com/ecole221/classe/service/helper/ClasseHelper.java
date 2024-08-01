package com.ecole221.classe.service.helper;

import com.ecole221.classe.service.dto.ClasseDto;
import com.ecole221.classe.service.exception.ClasseServiceException;
import com.ecole221.classe.service.service.ClasseService;
import org.springframework.stereotype.Component;

@Component
public class ClasseHelper {
    private final ClasseService classeService;

    public ClasseHelper(ClasseService classeService) {
        this.classeService = classeService;
    }

    public void checkClasse(ClasseDto classeDto){
        if (classeService.findByClasse(classeDto.getLibelleDto()) != null){
            throw new ClasseServiceException("La classe ["+classeDto.getLibelleDto()+"] existe déjà");
        }if(classeDto.getFraisInscriptionDto()<=0){
            throw new ClasseServiceException("Les frais d'inscription doivent être positifs");
        }
        if(classeDto.getAutreFraisDto()<=0){
            throw new ClasseServiceException("Les autres frais doivent être positifs");
        }
        if(classeDto.getMensualiteDto()<=0){
            throw new ClasseServiceException("La mensualité doit être positive");
        }

    }
}
