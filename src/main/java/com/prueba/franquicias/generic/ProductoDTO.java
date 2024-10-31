package com.prueba.franquicias.generic;

import lombok.Data;

@Data
public class ProductoDTO {
    private String nombre;
    private int stock;
    private Long sucursalId;
}
