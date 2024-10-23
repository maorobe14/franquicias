package com.evalart.franquicias.controller;
import com.evalart.franquicias.models.FranquiciaEntity;
import com.evalart.franquicias.services.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FranquiciaController implements BaseController {
    @Autowired
    private FranquiciaService franquiciaService;

    @PostMapping("/franquicia")
    public ResponseEntity<FranquiciaEntity> agregarFranquicia(@RequestBody FranquiciaEntity franquicia) {
        return ResponseEntity.ok(franquiciaService.crearFranquicia(franquicia));
    }

    // Endpoints para agregar sucursal y producto
}
