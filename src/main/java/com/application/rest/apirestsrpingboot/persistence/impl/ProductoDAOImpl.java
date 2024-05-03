package com.application.rest.apirestsrpingboot.persistence.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.rest.apirestsrpingboot.entities.Producto;
import com.application.rest.apirestsrpingboot.persistence.IProductoDAO;
import com.application.rest.apirestsrpingboot.repository.ProductoRepository;

@Component
public class ProductoDAOImpl implements IProductoDAO{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productoRepository.findProductoByPrecioBetween(minPrice, maxPrice);
    }

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

}
