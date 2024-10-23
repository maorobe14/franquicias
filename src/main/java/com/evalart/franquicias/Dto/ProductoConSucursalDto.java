package com.evalart.franquicias.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Builder
public class ProductoConSucursalDto {
    private Long productoId;
    private String productoNombre;
    private int stock;
    private Long sucursalId;
}
