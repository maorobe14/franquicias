package com.evalart.franquicias.repositories;
import com.evalart.franquicias.models.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    List<ProductoEntity> findBySucursalId(Long sucursalId);
}
