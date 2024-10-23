package com.evalart.franquicias.repositories;

import com.evalart.franquicias.models.ProductoEntity;
import com.evalart.franquicias.models.SucursalEntity;
import com.evalart.franquicias.repositories.projections.SucursalIdProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SucursalRepository extends JpaRepository<SucursalEntity, Long> {
    //List<SucursalEntity> findByFranquiciaId(Long franquiciaId);

    @Query("SELECT s.id FROM SucursalEntity s WHERE s.franquicia.id = :franquiciaId")
    List<Long> findIdsByFranquiciaId(@Param("franquiciaId") Long franquiciaId);

}
