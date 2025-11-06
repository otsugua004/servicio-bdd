package com.otsuguasoft.serviciobdd.data;

import com.otsuguasoft.serviciobdd.model.Informacion;
import com.otsuguasoft.serviciobdd.repository.InformacionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Component
public class InicializadorDatos {

    @Autowired
    private DataSource dataSource;


    @Autowired
    private InformacionRepository repositorio;

    @PostConstruct
    public void init() {
        if (!conexionDisponible()) {
            System.err.println("🚫 No se pudo conectar a PostgreSQL. Inicialización de registros cancelada.");
            return;
        }

        if (repositorio.count() == 0) {
            repositorio.saveAll(List.of(
                    new Informacion("Registro 1"),
                    new Informacion("Registro 2"),
                    new Informacion("Registro 3"),
                    new Informacion("Registro 4"),
                    new Informacion("Registro 5")
            ));
            System.out.println("✅ 5 registros inicializados");
        }
    }

    private boolean conexionDisponible() {
        try (Connection conn = dataSource.getConnection()) {
            return conn.isValid(2); // espera hasta 2 segundos
        } catch (SQLException e) {
            return false;
        }
    }

}
