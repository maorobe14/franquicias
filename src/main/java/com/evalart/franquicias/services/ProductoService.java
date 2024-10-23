package com.evalart.franquicias.services;

import com.evalart.franquicias.Dto.ProductoConSucursalDto;
import com.evalart.franquicias.models.ProductoEntity;
import com.evalart.franquicias.repositories.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductoService {

    private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private ProductoRepository productoRepository;

    private final SucursalService sucursalService;

    public ProductoService(@Lazy SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    public ProductoEntity crearProducto(Long sucursalId, ProductoEntity producto) {
        producto.setSucursal(sucursalService.obtenerSucursalPorId(sucursalId));
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long sucursalId, Long productoId) {

        productoRepository.delete(buscarProductoPorId(productoRepository.findBySucursalId(sucursalId), productoId));

    }

    public ProductoEntity buscarProductoPorId(List<ProductoEntity> productos, Long productoId) {
        return productos.stream()
                .filter(prod -> prod.getId().equals(productoId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en la sucursal"));
    }

    public ProductoEntity actualizarStock(Long productoId, int nuevoStock) {
        ProductoEntity producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(nuevoStock);
        return productoRepository.save(producto);
    }

    public List<ProductoConSucursalDto> obtenerProductoConMayorStockPorFranquicia(List<Long> idsSucursales) {

        List<ProductoConSucursalDto> resultado = new ArrayList<>();

        for (Long sucursalId : idsSucursales) {

            List<ProductoEntity> productos = productoRepository.findBySucursalId(sucursalId);

            ProductoEntity productoConMayorStock = obtenerProductoMayorStock(productos);

            if (productoConMayorStock != null)
                resultado.add(ProductoConSucursalDto.builder()
                        .productoId(productoConMayorStock.getId())
                        .productoNombre(productoConMayorStock.getNombre())
                        .stock(productoConMayorStock.getStock())
                        .sucursalId(sucursalId)
                        .build());
        }

        return resultado;

    }

    public ProductoEntity obtenerProductoMayorStock(List<ProductoEntity> productos) {
        return productos.stream()
                .max(Comparator.comparingInt(ProductoEntity::getStock))
                .orElse(null);
    }


}
