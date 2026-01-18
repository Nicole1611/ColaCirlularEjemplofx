/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.colacircularefx.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class CanvasCircularE extends Canvas {

    private List<String> values;

    public CanvasCircularE(double width, double height) {
        super(width, height);
    }

    public void setValues(List<String> values) {
        this.values = values;
        redraw();
    }

    private void redraw() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());

        if (values == null || values.isEmpty()) return;

        double x = 10;
        double y = getHeight() / 2;
        double boxWidth = 120;
        double boxHeight = 50;
        double gap = 20;

        gc.setFont(Font.font(12));

        for (String val : values) {
            // Dibuja el rectángulo
            gc.setFill(Color.WHITE);
            gc.fillRect(x, y - boxHeight / 2, boxWidth, boxHeight);
            gc.setStroke(Color.BLACK);
            gc.strokeRect(x, y - boxHeight / 2, boxWidth, boxHeight);

            // Escribe el texto centrado
            gc.setFill(Color.BLACK);
            gc.fillText(val, x + 5, y);

            x += boxWidth + gap;
        }

        // Ajusta el ancho del canvas según la cantidad de elementos
        setWidth(Math.max(getWidth(), x));
    }
}

