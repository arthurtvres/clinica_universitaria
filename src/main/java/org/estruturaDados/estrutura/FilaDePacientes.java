package org.estruturaDados.estrutura;
import org.estruturaDados.model.Paciente;

import java.util.LinkedList;

public class FilaDePacientes {
    private final LinkedList<Paciente> fila;

    public FilaDePacientes() {
        this.fila = new LinkedList<>();
    }

    // Adiciona paciente ao final da fila
    public void adicionarPaciente(Paciente paciente) {
        fila.addLast(paciente);
    }

    // Remove e retorna o próximo paciente (ou null se vazia)
    public Paciente chamarProximoPaciente() {
        return fila.isEmpty() ? null : fila.removeFirst();
    }

    // Retorna o próximo paciente sem remover (ou null se vazia)
    public Paciente proximoPaciente() {
        return fila.peekFirst();
    }

    // Exibe a fila no console
    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
            return;
        }
        System.out.println("Estado da fila:");
        int i = 1;
        for (Paciente p : fila) {
            String prioridade = (p != null && p.temPrioridade()) ? "SIM" : "NÃO";
            System.out.println(i + ". " + p.getNome() + " (Idade: " + p.getIdade() + ", Prioridade: " + prioridade + ")");
            i++;
        }
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public int size() {
        return fila.size();
    }
}
