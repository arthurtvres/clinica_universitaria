package org.estruturaDados;

import org.estruturaDados.estrutura.FilaDePacientes;
import org.estruturaDados.estrutura.ListaDeAtendidos;
import org.estruturaDados.model.Paciente;

public class Main {
    public static void main(String[] args) {
        FilaDePacientes fila = new FilaDePacientes();
        ListaDeAtendidos atendidos = new ListaDeAtendidos();

        Paciente p1 = new Paciente("Arthur");
        Paciente p2 = new Paciente("Cristiano");
        Paciente p3 = new Paciente("Neymar");
        Paciente p4 = new Paciente("Michelle");
        Paciente p5 = new Paciente("Julia");

        fila.enqueueue(p1);
        fila.enqueueue(p2);
        fila.enqueueue(p3);
        fila.enqueueue(p4);
        fila.enqueueue(p5);

        int atendimentos = 3;
        int realizados = 0;

        while (realizados < atendimentos && !fila.isEmpty()) {
            Paciente atendido = fila.dequeue();
            atendidos.adicionarAtendido(atendido.getNome());
            System.out.println("Atendido: " + atendido.getNome());
            realizados++;
        }
        System.out.println();

        System.out.println("Proximo paciente a ser atendido: " + fila.peek().getNome());

        System.out.println();

        atendidos.exibirAtendidos();

    }
}
