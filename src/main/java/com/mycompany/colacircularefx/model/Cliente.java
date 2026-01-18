/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.colacircularefx.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author anthony
 */
public class Cliente {
 
    public int id;
    public String nombre;
    public LocalDateTime llegada;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.llegada = LocalDateTime.now();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public LocalDateTime getLlegada() { return llegada; }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "#" + id + " " + nombre + " (" + llegada.format(f) + ")";
    }
}
