package com.ecole221.classe.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @AllArgsConstructor @NoArgsConstructor @Data
public class ErrorDto {
    private String code;
    private String message;

}
