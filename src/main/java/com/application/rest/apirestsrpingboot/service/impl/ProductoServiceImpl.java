package com.application.rest.apirestsrpingboot.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.rest.apirestsrpingboot.entities.Producto;
import com.application.rest.apirestsrpingboot.persistence.IProductoDAO;
import com.application.rest.apirestsrpingboot.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public List<Producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoDAO.findById(id);
    }

    @Override
    public List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productoDAO.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public void save(Producto Producto) {
        productoDAO.save(Producto);
    }

    @Override
    public void deleteById(Long id) {
        productoDAO.deleteById(id);
     }

}
