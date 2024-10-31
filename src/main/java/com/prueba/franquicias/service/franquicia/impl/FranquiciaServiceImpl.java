package com.prueba.franquicias.service.franquicia.impl;

import com.prueba.franquicias.generic.FranquiciaDTO;
import com.prueba.franquicias.model.entities.Franquicia;
import com.prueba.franquicias.repository.FranquiciaRepository;
import com.prueba.franquicias.service.franquicia.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranquiciaServiceImpl implements FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Override
    public Franquicia createFranquicia(FranquiciaDTO franquiciaDTO) {
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(franquiciaDTO.getNombre());
        return franquiciaRepository.save(franquicia);
    }

    @Override
    public Franquicia actualizarNombre(Long id, String nuevoNombre) {
        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        franquicia.setNombre(nuevoNombre);
        return franquiciaRepository.save(franquicia);
    }
}
