package com.ecole221.classe.service.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ClasseDto {

    private long idDto;

    @NotBlank(message = "Code Classe Obligatoire")
    private String libelleDto;

    @NotNull(message = "Frais Inscription Obligatoires!")
    @Min(value = 1, message = "Les frais d'inscription doivent être positifs")
    private int fraisInscriptionDto;

    @NotNull(message = "Mensualité Obligatoire!")
    @Min(value = 1, message = "Les frais d'inscription doivent être positifs")
    private int mensualiteDto;

    @NotNull(message = "Autres frais Obligatoires!")
    @Min(value = 1, message = "Les autres frais doivent être positifs---")
    private int autreFraisDto;

    private FiliereDto filiereDto;

}
