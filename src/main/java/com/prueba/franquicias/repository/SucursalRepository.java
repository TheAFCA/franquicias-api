package com.prueba.franquicias.repository;

import com.prueba.franquicias.model.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
