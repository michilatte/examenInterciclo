/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.examenpracticom5b.service;

import com.tap.m5b.examenpracticom5b.model.Empleado;
import com.tap.m5b.examenpracticom5b.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements GenericService<Empleado, Integer> {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return empleadoRepository;
    }  
}