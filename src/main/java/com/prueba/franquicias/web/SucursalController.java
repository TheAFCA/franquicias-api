package com.prueba.franquicias.web;

import com.prueba.franquicias.exception.FranquiciaNoEncontradaException;
import com.prueba.franquicias.generic.SucursalDTO;
import com.prueba.franquicias.model.entities.Sucursal;
import com.prueba.franquicias.service.sucursal.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/{franquiciaId}/sucursales")
    public ResponseEntity<Sucursal> addSucursal(@PathVariable Long franquiciaId, @RequestBody SucursalDTO sucursalDTO) {
        sucursalDTO.setFranquiciaId(franquiciaId);
        Sucursal nuevaSucursal = sucursalService.addSucursalToFranquicia(sucursalDTO);
        return new ResponseEntity<>(nuevaSucursal, HttpStatus.CREATED);
    }

    @ExceptionHandler(FranquiciaNoEncontradaException.class)
    public ResponseEntity<String> handleFranquiciaNoEncontrada(FranquiciaNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
