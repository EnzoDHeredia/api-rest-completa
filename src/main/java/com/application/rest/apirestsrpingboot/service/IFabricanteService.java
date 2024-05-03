package com.application.rest.apirestsrpingboot.service;

import java.util.List;
import java.util.Optional;

import com.application.rest.apirestsrpingboot.entities.Fabricante;

public interface IFabricanteService {
    List<Fabricante> findAll();

    Optional<Fabricante> findById(Long id);

    void save(Fabricante fabricante);

    void deleteById(Long id);
}
