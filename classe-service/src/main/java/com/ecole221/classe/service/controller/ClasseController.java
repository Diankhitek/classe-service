package com.ecole221.classe.service.controller;

import com.ecole221.classe.service.dto.ClasseDto;
import com.ecole221.classe.service.exception.ClasseServiceException;
import com.ecole221.classe.service.helper.ClasseHelper;
import com.ecole221.classe.service.mapper.Mapper;
import com.ecole221.classe.service.model.Classe;
import com.ecole221.classe.service.repository.ClasseRepository;
import com.ecole221.classe.service.service.ClasseService;
import com.ecole221.classe.service.service.Iclasse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.List;

@RestController
@RequestMapping("/api/classe/")
public class ClasseController {

    private final Mapper mapper;
    private final Iclasse classeService;
    private final ClasseHelper classeHelper;


    public ClasseController(Iclasse classeService, Mapper mapper, ClasseHelper classeHelper) {
        this.mapper = mapper;
        this.classeService = classeService;
        this.classeHelper = classeHelper;
    }

    @GetMapping(value = "gettAllClasse")
    public @ResponseBody List<ClasseDto> getAll() {
        return classeService.findAll().stream().map(mapper::classeEntityToClassDto).toList();
    }

    @PostMapping(value = "ajoutClasse")
    public @ResponseBody Classe addClasse(@Valid @RequestBody ClasseDto classeDto) {
        try {
            classeHelper.checkClasse(classeDto);
            return classeService.save(mapper.classeDtoToClasseEntity(classeDto));
        }catch (ClasseServiceException exception){
            throw new ClasseServiceException(exception.getMessage());
        }
    }

}
