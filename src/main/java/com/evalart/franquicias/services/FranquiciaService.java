package com.evalart.franquicias.services;

import com.evalart.franquicias.models.FranquiciaEntity;
import com.evalart.franquicias.models.ProductoEntity;
import com.evalart.franquicias.models.SucursalEntity;
import com.evalart.franquicias.repositories.FranquiciaRepository;
import com.evalart.franquicias.repositories.ProductoRepository;
import com.evalart.franquicias.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranquiciaService {
    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public FranquiciaEntity crearFranquicia(FranquiciaEntity franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public FranquiciaEntity obtenerFranquiciaPorId(Long franquiciaId) {
        FranquiciaEntity o = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        return o;
    }


}
