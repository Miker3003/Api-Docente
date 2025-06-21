package com.example.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.DocenteModel;
import com.example.repositories.DocenteRepository;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<DocenteModel> obtenerTodos() {
        return docenteRepository.findAll();
    }

    public DocenteModel crear(DocenteModel docente) {
        Optional<DocenteModel> existente = docenteRepository
            .findByTipoDocumentoAndNumeroDocumento(docente.getTipoDocumento(), docente.getNumeroDocumento());
        if (existente.isPresent()) {
            throw new RuntimeException("Ya existe un docente con ese tipo y número de documento.");
        }
        return docenteRepository.save(docente);
    }

    public DocenteModel actualizar(Long id, DocenteModel docenteActualizado) {
        DocenteModel docente = docenteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        docente.setNombres(docenteActualizado.getNombres());
        docente.setApellidos(docenteActualizado.getApellidos());
        docente.setEmail(docenteActualizado.getEmail());
        docente.setArea(docenteActualizado.getArea());
        return docenteRepository.save(docente);
    }

    public void eliminar(Long id) {
        if (!docenteRepository.existsById(id)) {
            throw new RuntimeException("Docente no encontrado");
        }
        docenteRepository.deleteById(id);
    }
}
