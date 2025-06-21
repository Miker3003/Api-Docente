package com.example.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.models.DocenteModel;

public interface DocenteRepository extends JpaRepository<DocenteModel, Long> {
    Optional<DocenteModel> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
 
}
