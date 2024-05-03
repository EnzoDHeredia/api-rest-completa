package com.application.rest.apirestsrpingboot.controllers.dto;

import java.util.List;

import com.application.rest.apirestsrpingboot.entities.Producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FabricanteDTO {
    private Long id;
    private String name;
    private List<Producto> productos;
}
