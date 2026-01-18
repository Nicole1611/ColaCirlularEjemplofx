/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.colacircularefx.model;

/**
 *
 * @author anthony
 */
public class ColaCircular <T>{

    public Object[] datos;
    public int front;
    public int rear;
    public int size;
    public int capacity;

    public ColaCircular(int capacity) {
        this.capacity = capacity;
        datos = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void enqueue(T value) {
        if (isFull()) throw new IllegalStateException("La cola está llena");
        rear = (rear + 1) % capacity;
        datos[rear] = value;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("La cola está vacía");
        @SuppressWarnings("unchecked")
        T val = (T) datos[front];
        datos[front] = null;
        front = (front + 1) % capacity;
        size--;
        if (size == 0) {
            front = 0;
            rear = -1;
        }
        return val;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("La cola está vacía");
        @SuppressWarnings("unchecked")
        T val = (T) datos[front];
        return val;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        int idx = front;
        for (int i = 0; i < size; i++) {
            sb.append(datos[idx]);
            if (i < size - 1) sb.append(", ");
            idx = (idx + 1) % capacity;
        }
        sb.append("]");
        return sb.toString();
    }
}