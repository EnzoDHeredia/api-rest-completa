package com.application.rest.apirestsrpingboot.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.application.rest.apirestsrpingboot.entities.Producto;

public interface IProductoService {
    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    void save(Producto Producto);

    void deleteById(Long id);
}
