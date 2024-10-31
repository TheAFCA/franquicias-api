package com.prueba.franquicias.web;

import com.prueba.franquicias.generic.ProductoDTO;
import com.prueba.franquicias.model.entities.Producto;
import com.prueba.franquicias.service.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/{sucursalId}/productos")
    public ResponseEntity<Producto> addProducto(@PathVariable Long sucursalId, @RequestBody ProductoDTO productoDTO) {
        productoDTO.setSucursalId(sucursalId);
        Producto nuevoProducto = productoService.addProductoToSucursal(productoDTO);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }
}
