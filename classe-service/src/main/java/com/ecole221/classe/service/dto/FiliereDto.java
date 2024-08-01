package com.ecole221.classe.service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FiliereDto {
    private long idDto;

    @NotNull(message = "Code libellé Obligatoire!")
    private String libelleDto;
}
