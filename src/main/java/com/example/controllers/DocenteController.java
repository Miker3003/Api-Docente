package com.example.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.models.DocenteModel;
import com.example.services.DocenteService;

@RestController
@RequestMapping("/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @PostMapping
    public DocenteModel crear(@RequestBody DocenteModel docente) {
        return docenteService.crear(docente);
    }

    @GetMapping
    public List<DocenteModel> obtenerTodos() {
        return docenteService.obtenerTodos();
    }

    @PutMapping("/{id}")
    public DocenteModel actualizar(@PathVariable Long id, @RequestBody DocenteModel docente) {
        return docenteService.actualizar(id, docente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        docenteService.eliminar(id);
    }
}
