package org.estruturaDados.estrutura;

import org.estruturaDados.model.Paciente;

public class FilaDePrioridade {

    private static class No {
        Paciente paciente;
        int prioridade;
        No proximo;

        No(Paciente paciente, int prioridade) {
            this.paciente = paciente;
            this.prioridade = prioridade;
            this.proximo = null;
        }
    }

    private No inicio;
    private int tamanho;
    private int totalInsercoes = 0;
    private long tempoTotalInsercao = 0;
    private long tempoTotalRemocao = 0;

    public FilaDePrioridade() {
        this.inicio = null;
        this.tamanho = 0;
    }

    private int obterPrioridade(Paciente paciente) {
        if (paciente.isUrgente()) return 1;
        if (paciente.getIdade() >= 60) return 2;
        return 3;
    }

    public void adicionarPaciente(Paciente paciente) {
        long inicioTempo = System.nanoTime();

        int prioridade = obterPrioridade(paciente);
        No novoNo = new No(paciente, prioridade);

        if (inicio == null || prioridade < inicio.prioridade) {
            novoNo.proximo = inicio;
            inicio = novoNo;
        } else {
            No atual = inicio;
            while (atual.proximo != null && atual.proximo.prioridade <= prioridade) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
        }

        tamanho++;

        long fimTempo = System.nanoTime();
        tempoTotalInsercao += (fimTempo - inicioTempo);
        totalInsercoes++;
    }

    public Paciente chamarProximoPaciente() {
        if (inicio == null) return null;

        long inicioTempo = System.nanoTime();

        Paciente paciente = inicio.paciente;
        inicio = inicio.proximo;
        tamanho--;


        long fimTempo = System.nanoTime();
        tempoTotalRemocao += (fimTempo - inicioTempo);

        return paciente;
    }

    public Paciente proximoPaciente() {
        return inicio != null ? inicio.paciente : null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public int size() {
        return tamanho;
    }

    public void exibirEstadoCompleto() {
        System.out.println("\n--- FILA DE PRIORIDADE ---");
        if (inicio == null) {
            System.out.println("A fila está vazia.");
            return;
        }

        No atual = inicio;
        int posicao = 1;
        int urgentes = 0, idosos = 0, normais = 0;

        while (atual != null) {
            System.out.println(posicao + ". " + atual.paciente.getNome() +
                    " (Idade: " + atual.paciente.getIdade() +
                    ", Prioridade: " + atual.prioridade + ")");

            if (atual.prioridade == 1) urgentes++;
            else if (atual.prioridade == 2) idosos++;
            else normais++;

            atual = atual.proximo;
            posicao++;
        }

        System.out.println("\nResumo: " + urgentes + " urgentes, " + idosos + " idosos, " + normais + " normais");
        System.out.println("Total: " + tamanho + " pacientes");
        System.out.println("====================================");
    }
}