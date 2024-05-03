package com.application.rest.apirestsrpingboot.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.rest.apirestsrpingboot.controllers.dto.FabricanteDTO;
import com.application.rest.apirestsrpingboot.entities.Fabricante;
import com.application.rest.apirestsrpingboot.service.IFabricanteService;

@RestController
@RequestMapping("/api/maker")
public class FabricanteController {

    @Autowired
    private IFabricanteService fabricanteService;


    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Fabricante> fabricanteOptional = fabricanteService.findById(id);

        if(fabricanteOptional.isPresent()){
            Fabricante fabricante = fabricanteOptional.get();

            FabricanteDTO fabricanteDTO = FabricanteDTO.builder()
                    .id(id)
                    .name(fabricante.getName())
                    .productos(fabricante.getProductos())
                    .build();

            return ResponseEntity.ok(fabricanteDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<FabricanteDTO> fabricanteDTO = fabricanteService.findAll()
                .stream()
                .map(fabricante -> FabricanteDTO.builder()
                                .id(fabricante.getId())
                                .name(fabricante.getName())
                                .productos(fabricante.getProductos())
                                .build())
                .toList();

        return ResponseEntity.ok(fabricanteDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FabricanteDTO fabricanteDTO) throws URISyntaxException{

        if(fabricanteDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        fabricanteService.save(Fabricante.builder()
                                        .name(fabricanteDTO.getName())
                                        .build());

        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFabricante(@PathVariable Long id, @RequestBody FabricanteDTO fabricanteDTO){

        Optional<Fabricante> fabrOptional = fabricanteService.findById(id);

        if(fabrOptional.isPresent()){
            Fabricante fabricante = fabrOptional.get();
            fabricante.setName(fabricanteDTO.getName());
            fabricanteService.save(fabricante);
            return ResponseEntity.ok("Registro Actualizado.");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if(id != null){
            fabricanteService.deleteById(id);
            return ResponseEntity.ok("Fabricante " + id + " Eliminado.");
        }

        return ResponseEntity.badRequest().build();
    }

}
