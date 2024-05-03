package com.application.rest.apirestsrpingboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.rest.apirestsrpingboot.entities.Fabricante;
import com.application.rest.apirestsrpingboot.persistence.IFabricanteDAO;
import com.application.rest.apirestsrpingboot.service.IFabricanteService;

@Service
public class FabricateServiceImpl implements IFabricanteService{

    @Autowired
    private IFabricanteDAO fabricanteDAO;

    @Override
    public List<Fabricante> findAll() {
        return fabricanteDAO.findAll();
    }

    @Override
    public Optional<Fabricante> findById(Long id) {
        return fabricanteDAO.findById(id);
    }

    @Override
    public void save(Fabricante fabricante) {
        fabricanteDAO.save(fabricante);
    }

    @Override
    public void deleteById(Long id) {
        fabricanteDAO.deleteById(id);
    }

}
