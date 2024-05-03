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

import com.application.rest.apirestsrpingboot.controllers.dto.ProductoDTO;
import com.application.rest.apirestsrpingboot.entities.Producto;
import com.application.rest.apirestsrpingboot.service.IProductoService;

@RestController
@RequestMapping("/api/product")
public class ProductoController {

    @Autowired
    private IProductoService productService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Producto> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Producto producto = productOptional.get();

            ProductoDTO productDTO = ProductoDTO.builder()
                    .id(id)
                    .nombre(producto.getNombre())
                    .precio(producto.getPrecio())
                    .fabricante(producto.getFabricante())
                    .build();

            return ResponseEntity.ok(productDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductoDTO> productDTO = productService.findAll()
                .stream()
                .map(producto -> ProductoDTO.builder()
                        .id(producto.getId())
                        .nombre(producto.getNombre())
                        .precio(producto.getPrecio())
                        .fabricante(producto.getFabricante())
                        .build())
                .toList();

        return ResponseEntity.ok(productDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO) throws URISyntaxException {

        if (productoDTO.getNombre().isBlank() || productoDTO.getPrecio() == null
                || productoDTO.getFabricante() == null) {
            return ResponseEntity.badRequest().build();
        }

        Producto producto = Producto.builder()
                .nombre(productoDTO.getNombre())
                .precio(productoDTO.getPrecio())
                .fabricante(productoDTO.getFabricante())
                .build();

        productService.save(producto);
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {

        Optional<Producto> prOptional = productService.findById(id);

        if (prOptional.isPresent()) {
            Producto producto = prOptional.get();
            producto.setNombre(productoDTO.getNombre());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setFabricante(productoDTO.getFabricante());
            productService.save(producto);
            return ResponseEntity.ok("Registro Actualizado.");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if (id != null) {
            productService.deleteById(id);
            return ResponseEntity.ok("Producto " + id + " Eliminado.");
        }

        return ResponseEntity.badRequest().build();
    }

}
