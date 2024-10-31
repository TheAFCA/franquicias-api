package com.prueba.franquicias.service.producto.impl;

import com.prueba.franquicias.exception.ProductoNoEncontradoException;
import com.prueba.franquicias.exception.SucursalNoEncontradaException;
import com.prueba.franquicias.generic.ProductoDTO;
import com.prueba.franquicias.model.entities.Producto;
import com.prueba.franquicias.model.entities.Sucursal;
import com.prueba.franquicias.repository.ProductoRepository;
import com.prueba.franquicias.repository.SucursalRepository;
import com.prueba.franquicias.service.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto addProductoToSucursal(ProductoDTO productoDTO) {
        Sucursal sucursal = sucursalRepository.findById(productoDTO.getSucursalId())
                .orElseThrow(() -> new SucursalNoEncontradaException("Sucursal con ID " + productoDTO.getSucursalId() + " no encontrada."));

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setStock(productoDTO.getStock());
        producto.setSucursal(sucursal);

        return productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long productoId) {
        if (!productoRepository.existsById(productoId)) {
            throw new ProductoNoEncontradoException("Producto con ID " + productoId + " no encontrado.");
        }
        productoRepository.deleteById(productoId);
    }

}
