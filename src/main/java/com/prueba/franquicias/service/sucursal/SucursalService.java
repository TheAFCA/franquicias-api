package com.prueba.franquicias.service.sucursal;

import com.prueba.franquicias.generic.SucursalDTO;
import com.prueba.franquicias.model.entities.Sucursal;

public interface SucursalService {
    public Sucursal addSucursalToFranquicia(SucursalDTO sucursalDTO);
    public Sucursal actualizarNombre(Long id, String nuevoNombre);
}
