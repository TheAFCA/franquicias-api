package com.prueba.franquicias.service.producto;

import com.prueba.franquicias.generic.ProductoDTO;
import com.prueba.franquicias.model.entities.Producto;

import java.util.List;

public interface ProductoService {
    Producto addProductoToSucursal(ProductoDTO productoDTO);
    void deleteProducto(Long productoId);
    public Producto updateStock(Long productoId, ProductoDTO productoDTO);
    public List<Producto> getProductoConMayorStockPorFranquicia(Long franquiciaId);
    public Producto actualizarNombre(Long id, String nuevoNombre);
}
