/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.examenpracticom5b.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id_empleado;

    @Column(name = "cedula")
    private String cedula;

    //@Size(min = 4, max = 45, message = "El apellido debe tener maximo 45 caracteres")
    @NotBlank(message = "Llene el campo apellido")
    @Column(name = "apellido")
    private String apellido;

    //@Size(min = 4, max = 45, message = "El nombre debe tener maximo 45 caracteres")
    @NotBlank(message = "Llene el campo nombre")
    @Column(name = "nombre")
    private String nombre;

   // @Size(min = 7, max = 15, message = "El telefono debe tener maximo 15 digitos")
    @NotBlank(message = "Llene el campo telefono")
    @Column(name = "telefono")
    private String telefono;

    //@Size(min = 4, max = 45, message = "El apellido debe tener maximo 45 caracteres")
    @NotBlank(message = "Llene el campo direccion")
    @Column(name = "direccion")
    private String direccion;

    @NotBlank(message = "Llene el fecha de nacimiento")
    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;

    @Size(min = 4, max = 45, message = "El apellido debe tener maximo 45 caracteres")
    @NotBlank(message = "Llene el campo observacion")
    @Column(name = "observacion")
    private String observacion;

    @Column(name = "dias_trabajo")
    private int dias_trabajo;

    @Column(name = "sueldo")
    private double sueldo;

}
