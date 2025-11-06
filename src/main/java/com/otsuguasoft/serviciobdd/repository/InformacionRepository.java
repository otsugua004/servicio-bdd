package com.otsuguasoft.serviciobdd.repository;


import com.otsuguasoft.serviciobdd.model.Informacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformacionRepository extends JpaRepository<Informacion, Long> {
}