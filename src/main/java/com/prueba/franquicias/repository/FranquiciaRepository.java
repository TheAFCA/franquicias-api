package com.prueba.franquicias.repository;

import com.prueba.franquicias.model.entities.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
}
