package com.ecole221.classe.service.controller;

import com.ecole221.classe.service.dto.ClasseDto;
import com.ecole221.classe.service.exception.ClasseServiceException;
import com.ecole221.classe.service.exception.ClasseServiceNotFoundException;
import com.ecole221.classe.service.helper.ClasseHelper;
import com.ecole221.classe.service.mapper.Mapper;
import com.ecole221.classe.service.model.Classe;
import com.ecole221.classe.service.repository.ClasseRepository;
import com.ecole221.classe.service.service.ClasseService;
import com.ecole221.classe.service.service.Iclasse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "addClasse")
    public @ResponseBody Classe addClasse(@Valid @RequestBody ClasseDto classeDto) {
        try {
            classeHelper.checkClasse(classeDto);
            return classeService.save(mapper.classeDtoToClasseEntity(classeDto));
        }catch (ClasseServiceException exception){
            throw new ClasseServiceException(exception.getMessage());
        }
    }
/*

    @PutMapping(value = "updateClasse/{id}")
    public ResponseEntity<String> updateClasse(@Valid @PathVariable long id, @RequestBody ClasseDto classeDto) {
        try {
            classeHelper.checkClasse(classeDto);
            if(classeService.findById(id)==null){
                throw new ClasseServiceNotFoundException("La classe d'id " + id + " n'existe pas");
            }
            Classe c = mapper.classeDtoToClasseEntity(classeDto);

            System.out.println("MENNNN "+c.getMensualite());
            classeService.updateClasseById(id, c);
            return ResponseEntity.ok("Classe updated successfully");
        }catch (ClasseServiceException exception){
            throw new ClasseServiceException(exception.getMessage());
        }
    }
*/

    @PutMapping(value = "updateClasse/{id}")
    public ResponseEntity<String> updateClasse(@Valid @PathVariable long id, @RequestBody ClasseDto classeDto) {
        try {
            classeHelper.checkClasse(classeDto);
            Classe updatedClasse = classeService.updateClasseById(id, mapper.classeDtoToClasseEntity(classeDto));
            return ResponseEntity.ok("Classe updated successfully");
        } catch (ClasseServiceNotFoundException e) {
            throw new ClasseServiceNotFoundException(e.getMessage());
        } catch (ClasseServiceException e) {
            throw new ClasseServiceException(e.getMessage());
        }
    }

    @GetMapping(value = "getClasseById/{id}")
    public @ResponseBody ClasseDto getClasseById(@PathVariable long id) {
        Classe classe = classeService.findById(id);
        if (classe == null) {
            throw new ClasseServiceNotFoundException("La classe d'id " + id + " n'existe pas");
        }
        return mapper.classeEntityToClassDto(classe);
    }



    @DeleteMapping(value = "removeClasse/{id}")
    public ResponseEntity <String> removeClasse(@PathVariable long id) {
        Classe classe = classeService.findById(id);
        if (classe == null) {
            throw new ClasseServiceNotFoundException("La classe d'id " + id + " n'existe pas");
        }
        classeService.remove(classe);
        return ResponseEntity.ok("Deleted classe " + id);
    }

}
