package com.application.rest.apirestsrpingboot.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.rest.apirestsrpingboot.entities.Fabricante;
import com.application.rest.apirestsrpingboot.persistence.IFabricanteDAO;
import com.application.rest.apirestsrpingboot.repository.FabricanteRepository;

@Component
public class FabricanteDAOImpl implements IFabricanteDAO{

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public List<Fabricante> findAll() {
        return (List<Fabricante>) fabricanteRepository.findAll();
    }

    @Override
    public Optional<Fabricante> findById(Long id) {
        return fabricanteRepository.findById(id);
    }

    @Override
    public void save(Fabricante fabricante) {
        fabricanteRepository.save(fabricante);
    }

    @Override
    public void deleteById(Long id) {
        fabricanteRepository.deleteById(id);
    }
}
