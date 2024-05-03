package com.application.rest.apirestsrpingboot.persistence;

import java.util.List;
import java.util.Optional;

import com.application.rest.apirestsrpingboot.entities.Fabricante;

public interface IFabricanteDAO {

    List<Fabricante> findAll();

    Optional<Fabricante> findById(Long id);

    void save(Fabricante fabricante);

    void deleteById(Long id);

}
