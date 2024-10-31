package com.prueba.franquicias.service.sucursal.impl;

import com.prueba.franquicias.exception.FranquiciaNoEncontradaException;
import com.prueba.franquicias.generic.SucursalDTO;
import com.prueba.franquicias.model.entities.Franquicia;
import com.prueba.franquicias.model.entities.Sucursal;
import com.prueba.franquicias.repository.FranquiciaRepository;
import com.prueba.franquicias.repository.SucursalRepository;
import com.prueba.franquicias.service.sucursal.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public Sucursal addSucursalToFranquicia(SucursalDTO sucursalDTO) {
        Franquicia franquicia = franquiciaRepository.findById(sucursalDTO.getFranquiciaId())
                .orElseThrow(() -> new FranquiciaNoEncontradaException("Franquicia con ID " + sucursalDTO.getFranquiciaId() + " no encontrada."));

        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalDTO.getNombre());
        sucursal.setFranquicia(franquicia);

        return sucursalRepository.save(sucursal);
    }
}
