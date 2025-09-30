package org.estruturaDados.estrutura;

import org.estruturaDados.model.Paciente;

public class FilaEncadeada {
    private static class No {
        Paciente paciente;
        No proximo;
        No(Paciente paciente) {
            this.paciente = paciente;
        }
    }

    private No inicio;
    private No fim;
    private int tamanho;

    public FilaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void enqueue(Paciente paciente) {
        No novo = new No(paciente);
        if (fim != null) fim.proximo = novo;
        fim = novo;
        if (inicio == null) inicio = novo;
        tamanho++;
    }

    public Paciente dequeue() {
        if (inicio == null) return null;
        Paciente paciente = inicio.paciente;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        tamanho--;
        return paciente;
    }

    public Paciente peek() {
        if (inicio == null) return null;
        return inicio.paciente;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

}

