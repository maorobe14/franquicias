package com.evalart.franquicias.services;

import com.evalart.franquicias.Dto.ProductoConSucursalDto;
import com.evalart.franquicias.models.FranquiciaEntity;
import com.evalart.franquicias.models.SucursalEntity;
import com.evalart.franquicias.repositories.FranquiciaRepository;
import com.evalart.franquicias.repositories.SucursalRepository;
import com.evalart.franquicias.repositories.projections.SucursalIdProjection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalService {

    private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private FranquiciaService franquiciaService;

    @Autowired
    private ProductoService productoService;

    public SucursalEntity crearSucursal(Long franquiciaId ,SucursalEntity sucursal) {

        FranquiciaEntity b = franquiciaService.obtenerFranquiciaPorId(franquiciaId);
        sucursal.setFranquicia(b);
        return sucursalRepository.save(sucursal);
    }

    public SucursalEntity obtenerSucursalPorId(Long sucursalId) {
        SucursalEntity n = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        return n;
    }

    public List<ProductoConSucursalDto> obtenerProductoConMayorStockPorSucursal(Long franquiciaId) {

        List<Long> idsSucursales = sucursalRepository.findIdsByFranquiciaId(franquiciaId);

        return productoService.obtenerProductoConMayorStockPorFranquicia(idsSucursales);

        //return null;
    }


}
