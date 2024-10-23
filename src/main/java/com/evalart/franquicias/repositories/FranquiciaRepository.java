package com.evalart.franquicias.repositories;
import com.evalart.franquicias.models.FranquiciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranquiciaRepository extends JpaRepository<FranquiciaEntity, Long> {
}
