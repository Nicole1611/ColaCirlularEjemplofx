/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.colacircularefx.model;

import com.mycompany.colacircularefx.model.Cliente;
import com.mycompany.colacircularefx.model.ColaCircular;

/**
 *
 * @author anthony
 */
public class TurnoModel {

    public ColaCircular<Cliente> cola;
    public int nextId = 1;

    public TurnoModel(int capacidad) {
        cola = new ColaCircular<>(capacidad);
    }

    public Cliente agregarCliente(String nombre) {
        Cliente c = new Cliente(nextId++, nombre);
        cola.enqueue(c);
        return c;
    }

    public Cliente atender() {
        return cola.dequeue();
    }

    public Cliente siguiente() {
        return cola.peek();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public boolean estaLlena() {
        return cola.isFull();
    }

    public String estado() {
        return cola.toString();
    }
    

    public int getSize() { return cola.size(); }
}