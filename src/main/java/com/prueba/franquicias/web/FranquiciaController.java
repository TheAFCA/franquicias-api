package com.prueba.franquicias.web;

import com.prueba.franquicias.generic.FranquiciaDTO;
import com.prueba.franquicias.model.entities.Franquicia;
import com.prueba.franquicias.service.franquicia.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {
    @Autowired
    private FranquiciaService franquiciaService;

    @PostMapping
    public ResponseEntity<Franquicia> crearFranquicia(@RequestBody FranquiciaDTO franquiciaDTO) {
        Franquicia nuevaFranquicia = franquiciaService.createFranquicia(franquiciaDTO);
        return new ResponseEntity<>(nuevaFranquicia, HttpStatus.CREATED);
    }
}
