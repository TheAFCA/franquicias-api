package com.prueba.franquicias.service.producto;

import com.prueba.franquicias.generic.ProductoDTO;
import com.prueba.franquicias.model.entities.Producto;

public interface ProductoService {
    Producto addProductoToSucursal(ProductoDTO productoDTO);
}
