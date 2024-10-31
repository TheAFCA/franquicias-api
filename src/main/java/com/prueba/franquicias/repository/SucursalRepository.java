package com.prueba.franquicias.repository;

import com.prueba.franquicias.model.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    List<Sucursal> findByFranquiciaId(Long franquiciaId);
}
