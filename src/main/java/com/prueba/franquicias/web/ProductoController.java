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

import java.util.List;

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

    @PutMapping("/{productoId}/stock")
    public ResponseEntity<Producto> updateProductStock(@PathVariable Long productoId, @RequestBody ProductoDTO productoDTO) {
        Producto actualizado = productoService.updateStock(productoId, productoDTO);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/{franquiciaId}/productos-mayor-stock")
    public ResponseEntity<List<Producto>> getProductoConMayorStockPorFranquicia(@PathVariable Long franquiciaId) {
        List<Producto> productos = productoService.getProductoConMayorStockPorFranquicia(franquiciaId);
        return ResponseEntity.ok(productos);
    }

    @PutMapping("/{id}/nombre")
    public ResponseEntity<Producto> actualizarNombre(@PathVariable Long id, @RequestParam String nuevoNombre) {
        Producto actualizado = productoService.actualizarNombre(id, nuevoNombre);
        return ResponseEntity.ok(actualizado);
    }

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<String> handleProductoNoEncontrado(ProductoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(SucursalNoEncontradaException.class)
    public ResponseEntity<String> handleSucursalNoEncontrada(SucursalNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
