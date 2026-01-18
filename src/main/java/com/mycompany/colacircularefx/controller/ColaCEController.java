/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.colacircularefx.controller;


import com.mycompany.colacircularefx.model.Cliente;
import com.mycompany.colacircularefx.model.TurnoModel;
import com.mycompany.colacircularefx.view.CanvasCircularE;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.List;

public class ColaCEController {

    @FXML
    private StackPane canvasPane;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnAtender;

    @FXML
    private Button btnPeek;

    @FXML
    private Button btnIsEmpty;



    @FXML
    private Label lblEstado;

    private TurnoModel model;
    private CanvasCircularE canvas;

    @FXML
    public void initialize() {
        model = new TurnoModel(5); // capacidad de 5
        canvas = new CanvasCircularE(600, 100);
        canvasPane.getChildren().add(canvas);
        refreshView();
    }

    @FXML
    private void agregarCliente() {
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            lblEstado.setText("Ingrese un nombre");
            return;
        }
        try {
            model.agregarCliente(nombre);
            lblEstado.setText("Cliente agregado: " + nombre);
            txtNombre.clear();
            refreshView();
        } catch (IllegalStateException e) {
            lblEstado.setText("Cola llena, no se puede agregar");
        }
    }

    @FXML
    private void atenderCliente() {
        try {
            Cliente c = model.atender();
            lblEstado.setText("Cliente atendido: " + c.getNombre());
            refreshView();
        } catch (IllegalStateException e) {
            lblEstado.setText("Cola vacía");
        }
    }

    @FXML
    private void peekCliente() {
        try {
            Cliente c = model.siguiente();
            lblEstado.setText("Siguiente cliente: " + c.getNombre());
        } catch (IllegalStateException e) {
            lblEstado.setText("Cola vacía");
        }
    }

    @FXML
    private void isEmpty() {
        lblEstado.setText(model.estaVacia() ? "La cola está vacía" : "La cola NO está vacía");
    }

    @FXML
    private void isFull() {
        lblEstado.setText(model.estaLlena() ? "La cola está llena" : "La cola NO está llena");
    }

    private void refreshView() {
        List<String> values = new ArrayList<>();
        int idx = model.cola.front;
        for (int i = 0; i < model.getSize(); i++) {
            Cliente c = (Cliente) model.cola.datos[idx];
            values.add(c.toString());
            idx = (idx + 1) % model.cola.capacity;
        }
        canvas.setValues(values);
    }
}
