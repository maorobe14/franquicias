package com.evalart.franquicias.controller;

import com.evalart.franquicias.Dto.ProductoConSucursalDto;
import com.evalart.franquicias.models.FranquiciaEntity;
import com.evalart.franquicias.models.SucursalEntity;
import com.evalart.franquicias.services.FranquiciaService;
import com.evalart.franquicias.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SucursalController implements BaseController {

    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/sucursal/{franquiciaId}")
    public ResponseEntity<SucursalEntity> agregarSucursal(@PathVariable Long franquiciaId, @RequestBody SucursalEntity sucursal) {
        return ResponseEntity.ok(sucursalService.crearSucursal(franquiciaId, sucursal));
    }

    @GetMapping("/sucursal")
    public String hola() {
        return "hello  sad";
    }

    @GetMapping(value = "/sucursal/max-stock/{franquiciaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductoConSucursalDto>> obtenerProductosConMayorStock(@PathVariable Long franquiciaId) {
        List<ProductoConSucursalDto> productos = sucursalService.obtenerProductoConMayorStockPorSucursal(franquiciaId);
        return ResponseEntity.ok(productos);
    }
}
