package com.application.rest.apirestsrpingboot.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.application.rest.apirestsrpingboot.entities.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

    List<Producto> findProductoByPrecioBetween(BigDecimal minPrice, BigDecimal maxPrice);

}
