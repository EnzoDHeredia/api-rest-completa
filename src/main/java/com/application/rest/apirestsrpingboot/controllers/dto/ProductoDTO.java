package com.application.rest.apirestsrpingboot.controllers.dto;

import java.math.BigDecimal;

import com.application.rest.apirestsrpingboot.entities.Fabricante;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Fabricante fabricante;
}
