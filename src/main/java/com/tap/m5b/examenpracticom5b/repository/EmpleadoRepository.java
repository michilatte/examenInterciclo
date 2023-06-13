/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.examenpracticom5b.repository;

import com.tap.m5b.examenpracticom5b.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
        @Query(value = "Select * from empleado e where e.cedula = :cedula", nativeQuery = true)
    public Empleado buscarInventario(String cedula);
}

