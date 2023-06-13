/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.examenpracticom5b.controller;

import com.tap.m5b.examenpracticom5b.model.Empleado;
import com.tap.m5b.examenpracticom5b.service.EmpleadoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoServiceImpl empleadoService;

    @Operation(summary = "Obtener lista de EMPLEADOS")
    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> listaEmpleados() {
        return new ResponseEntity<>(empleadoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Enviar los campos del EMPLEADO")
    @PostMapping("/crear")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado emp) {
        double sueldocalculado;
        if (emp.getDias_trabajo() >= 20 && emp.getDias_trabajo() < 30) {
            sueldocalculado = emp.getSueldo() + (emp.getDias_trabajo() * 15); 
            sueldocalculado += sueldocalculado * 0.02; // Bono del 2%
            emp.setSueldo(sueldocalculado);
        } else if (emp.getDias_trabajo() >= 30) {
            sueldocalculado = emp.getSueldo() + (emp.getDias_trabajo() * 15); 
            sueldocalculado += sueldocalculado * 0.05; // Bono del 5%
            emp.setSueldo(sueldocalculado);
        } else {
            sueldocalculado = emp.getSueldo() + (emp.getDias_trabajo() * 15); 
            emp.setSueldo(sueldocalculado);
        }

        return new ResponseEntity<>(empleadoService.save(emp), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado emp) {
        Empleado empleado = empleadoService.findById(id);

        if (empleado != null) {
            try {
                empleado.setCedula(emp.getCedula());
                empleado.setApellido(emp.getApellido());
                empleado.setNombre(emp.getNombre());
                empleado.setTelefono(emp.getTelefono());
                empleado.setDireccion(emp.getDireccion());
                empleado.setFecha_nacimiento(emp.getFecha_nacimiento());
                empleado.setObservacion(emp.getObservacion());
                empleado.setDias_trabajo(emp.getDias_trabajo());
                empleado.setSueldo(emp.getSueldo());

                return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Empleado> eliminarEmpleado(@PathVariable Integer id) {
        empleadoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
