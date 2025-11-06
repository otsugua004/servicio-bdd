package com.otsuguasoft.serviciobdd.controller;


import com.otsuguasoft.serviciobdd.model.Informacion;
import com.otsuguasoft.serviciobdd.repository.InformacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/bdd")
public class InformacionController {

    private final InformacionRepository repository;

    @Autowired
    private DataSource dataSource;

    public InformacionController(InformacionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        // Validar conexión a PostgreSQL
        try (Connection conn = dataSource.getConnection()) {
            if (!conn.isValid(2)) {
                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body("PostgreSQL no disponible");
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Error de conexión: " + e.getMessage());
        }

        // Buscar información
        return repository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontró información para el ID: " + id));
    }

}