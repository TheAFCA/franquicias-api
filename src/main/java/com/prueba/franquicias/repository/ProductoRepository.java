package com.prueba.franquicias.repository;

import com.prueba.franquicias.model.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
