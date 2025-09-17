package org.estruturaDados.estrutura;
import org.estruturaDados.model.Paciente;

import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class FilaDePacientes {
    private LinkedList<Paciente> fila;

    public FilaDePacientes() {
        this.fila = new LinkedList<>();
    }

    public void enqueueue(Paciente paciente) {
        fila.addLast(paciente);
    }

    public Paciente dequeue() {
        if (fila.isEmpty()) {
            throw new NoSuchElementException("A fila está vazia.");
        }
        return fila.removeFirst();
    }

    public Paciente peek (){
        if (fila.isEmpty()) {
            throw new NoSuchElementException("A fila está vazia não há pacientes.");
        }
        return fila.getFirst();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public int size() {
        return fila.size();
    }
}
