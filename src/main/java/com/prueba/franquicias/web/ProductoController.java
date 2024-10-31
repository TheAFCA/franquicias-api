package com.prueba.franquicias.web;

import com.prueba.franquicias.exception.ProductoNoEncontradoException;
import com.prueba.franquicias.exception.SucursalNoEncontradaException;
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

    @DeleteMapping("/{productoId}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long productoId) {
        productoService.deleteProducto(productoId);
        return ResponseEntity.ok("Producto eliminado con éxito.");
    }

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<String> handleProductoNoEncontrado(ProductoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(SucursalNoEncontradaException.class)
    public ResponseEntity<String> handleSucursalNoEncontrada(SucursalNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
