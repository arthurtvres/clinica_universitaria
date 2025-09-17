package org.estruturaDados.estrutura;

import org.estruturaDados.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class ListaDeAtendidos {
    private List<String> atendidos;

    public ListaDeAtendidos() {
        this.atendidos = new ArrayList<>();
    }

    public void adicionarAtendido(String nome) {
        atendidos.add(nome);
    }

    public void exibirAtendidos() {
        if(atendidos.isEmpty()) {
            System.out.println("Nenhum paciente foi atendido ainda.");
        } else {
            System.out.println("Pacientes atendidos:");
            for (String nome : atendidos) {
                System.out.println("- " + nome);
            }
        }
    }

    public boolean foiAtendido(String nome) {
        for (String nomeAtendido : atendidos) {
            if (nomeAtendido.equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public int totalAtendidos() {
        return atendidos.size();
    }
}
