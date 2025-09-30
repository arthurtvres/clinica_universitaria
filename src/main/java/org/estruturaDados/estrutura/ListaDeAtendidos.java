package org.estruturaDados.estrutura;

import org.estruturaDados.model.Paciente;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaDeAtendidos {
    private List<Paciente> atendidos;

    public ListaDeAtendidos() {
        this.atendidos = new ArrayList<>();
    }

    public void adicionarAtendido(Paciente paciente) {
        atendidos.add(paciente);
    }

    public void exibirAtendidos() {
        if (atendidos.isEmpty()) {
            System.out.println("Nenhum paciente foi atendido ainda.");
        } else {
            System.out.println("Pacientes atendidos:");
            for (Paciente p : atendidos) {
                System.out.println("- " + p.getNome() + " (Idade: " + p.getIdade() + ")");
            }
        }
    }

    public boolean foiAtendido(String nome) {
        for (Paciente p : atendidos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public int totalAtendidos() {
        return atendidos.size();
    }

    public double mediaIdade() {
        if (atendidos.isEmpty()) return 0;
        int soma = 0;
        for (Paciente p : atendidos) {
            soma += p.getIdade();
        }
        return (double) soma / atendidos.size();
    }

    public Paciente pacienteMaisIdoso() {
        if (atendidos.isEmpty()) return null;
        Paciente maisVelho = atendidos.get(0);
        for (Paciente p : atendidos) {
            if (p.getIdade() > maisVelho.getIdade()) {
                maisVelho = p;
            }
        }
        return maisVelho;
    }

    public void exibirRelatorio() {
        System.out.println("\n=== Relatório Diário ===");
        System.out.println("Total de pacientes atendidos: " + totalAtendidos());
        System.out.println("Média de idade: " + String.format("%.2f", mediaIdade()));

        Paciente maisVelho = pacienteMaisIdoso();
        if (maisVelho != null) {
            System.out.println("Paciente mais idoso: " + maisVelho.getNome() +
                    " (" + maisVelho.getIdade() + " anos)");
        } else {
            System.out.println("Nenhum paciente atendido.");
        }
        System.out.println("=========================");
    }

    // Desafio extra: exportar para arquivo .txt
    public void exportarRelatorio(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write("=== Relatório Diário ===\n");
            writer.write("Total de pacientes atendidos: " + totalAtendidos() + "\n");
            writer.write("Média de idade: " + String.format("%.2f", mediaIdade()) + "\n");

            Paciente maisVelho = pacienteMaisIdoso();
            if (maisVelho != null) {
                writer.write("Paciente mais idoso: " + maisVelho.getNome() +
                        " (" + maisVelho.getIdade() + " anos)\n");
            } else {
                writer.write("Nenhum paciente atendido.\n");
            }
            writer.write("=========================\n");
            System.out.println("Relatório exportado para: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao exportar relatório: " + e.getMessage());
        }
    }
}
