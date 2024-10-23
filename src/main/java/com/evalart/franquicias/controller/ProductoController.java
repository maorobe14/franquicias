package com.evalart.franquicias.controller;

import com.evalart.franquicias.models.ProductoEntity;
import com.evalart.franquicias.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController implements BaseController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/producto/{sucursalId}")
    public ResponseEntity<ProductoEntity> agregarProducto(@PathVariable Long sucursalId, @RequestBody ProductoEntity producto) {
        return ResponseEntity.ok(productoService.crearProducto(sucursalId, producto));
    }

    @DeleteMapping("/producto/{sucursalId}/{productoId}")
    public ResponseEntity<Void> eliminarProducto( @PathVariable Long sucursalId, @PathVariable Long productoId) {
        productoService.eliminarProducto(sucursalId, productoId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/producto/stock/{productoId}")
    public ResponseEntity<ProductoEntity> modificarStock(@PathVariable Long productoId, @RequestBody int nuevoStock) {
        return ResponseEntity.ok(productoService.actualizarStock(productoId, nuevoStock));
    }
/*
    @GetMapping("/{franquiciaId}/mayor-stock")
    public ResponseEntity<List<ProductoEntity>> obtenerProductosMayorStock(@PathVariable Long franquiciaId) {
        return ResponseEntity.ok(productoService.obtenerProductosMayorStock(franquiciaId));
    }*/


}
