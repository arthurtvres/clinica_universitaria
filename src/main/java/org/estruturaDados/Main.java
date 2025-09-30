package org.estruturaDados;

import org.estruturaDados.estrutura.*;
import org.estruturaDados.model.Paciente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n=== MENU DE TESTES - FILAS ===");
            System.out.println("1 - Teste: Fila (ArrayList - FilaDePacientes)");
            System.out.println("2 - Teste: Fila Circular");
            System.out.println("3 - Teste: Fila Encadeada");
            System.out.println("4 - Teste: Fila de Prioridade");
            System.out.println("5 - Teste: Lista de Atendidos (relatório)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    testeFilaDePacientes();
                    break;
                case 2:
                    testeFilaCircular();
                    break;
                case 3:
                    testeFilaEncadeada();
                    break;
                case 4:
                    testeFilaDePrioridade();
                    break;
                case 5:
                    testeListaDeAtendidos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void testeFilaDePacientes() {
        System.out.println("\n--- TESTE: FilaDePacientes ---");
        FilaDePacientes fila = new FilaDePacientes();
        ListaDeAtendidos atendidos = new ListaDeAtendidos();

        fila.adicionarPaciente(new Paciente("João Silva", 45, "123.456.789-01"));
        fila.adicionarPaciente(new Paciente("Maria Santos", 65, "234.567.890-12"));
        fila.adicionarPaciente(new Paciente("Pedro Oliveira", 30, "345.678.901-23"));

        fila.exibirFila();

        for (int i = 0; i < 2; i++) {
            Paciente p = fila.chamarProximoPaciente();
            if (p != null) {
                System.out.println("Atendendo: " + p.getNome());
                atendidos.adicionarAtendido(p);
            }
        }

        // Mostrar estado atual da fila e lista de atendidos
        fila.exibirFila();
        atendidos.exibirAtendidos();
    }

    private static void testeFilaCircular() {
        System.out.println("\n--- TESTE: Fila Circular ---");
        FilaCircular fila = new FilaCircular(5);
        ListaDeAtendidos atendidos = new ListaDeAtendidos();

        fila.enqueue(new Paciente("Alice Ferreira", 35, "111.222.333-44"));
        fila.enqueue(new Paciente("Bruno Lima", 28, "222.333.444-55"));
        fila.enqueue(new Paciente("Carla Souza", 42, "333.444.555-66"));

        System.out.println("Próximo: " + (fila.peek() != null ? fila.peek().getNome() : "Nenhum"));

        for (int i = 0; i < 2; i++) {
            Paciente p = fila.dequeue();
            if (p != null) {
                System.out.println("Atendido: " + p.getNome());
                atendidos.adicionarAtendido(p);
            }
        }

        fila.enqueue(new Paciente("Diego Pereira", 31, "444.555.666-77"));
        fila.enqueue(new Paciente("Elena Martins", 39, "555.666.777-88"));

        while (!fila.isEmpty()) {
            Paciente p = fila.dequeue();
            if (p != null) {
                System.out.println("Finalizando: " + p.getNome());
                atendidos.adicionarAtendido(p);
            }
        }

        atendidos.exibirAtendidos();
    }

    private static void testeFilaEncadeada() {
        System.out.println("\n--- TESTE: Fila Encadeada ---");
        FilaEncadeada fila = new FilaEncadeada();
        ListaDeAtendidos atendidos = new ListaDeAtendidos();

        fila.enqueue(new Paciente("Hugo Oliveira", 44, "888.999.000-11"));
        fila.enqueue(new Paciente("Isabela Rocha", 37, "999.000.111-22"));
        fila.enqueue(new Paciente("Joaquim Silva", 52, "000.111.222-33"));

        System.out.println("Próximo: " + (fila.peek() != null ? fila.peek().getNome() : "Nenhum"));

        while (!fila.isEmpty()) {
            Paciente p = fila.dequeue();
            if (p != null) {
                System.out.println("Atendido: " + p.getNome());
                atendidos.adicionarAtendido(p);
            }
        }

        atendidos.exibirAtendidos();
    }

    private static void testeFilaDePrioridade() {
        System.out.println("\n--- TESTE: Fila de Prioridade ---");
        FilaDePrioridade fila = new FilaDePrioridade();

        fila.adicionarPaciente(new Paciente("Paciente Normal", 30, "101.101.101-10"));
        fila.adicionarPaciente(new Paciente("Paciente Idoso", 75, "202.202.202-20"));
        fila.adicionarPaciente(new Paciente("Paciente Urgente", 40, "303.303.303-30", false, true));

        fila.exibirEstadoCompleto();

        // chamarProximoPaciente já imprime detalhes; evitar prints duplicados aqui
        for (int i = 0; i < 2; i++) {
            fila.chamarProximoPaciente();
        }

        System.out.println("Estado final da fila de prioridade:");
        fila.exibirEstadoCompleto();
    }

    private static void testeListaDeAtendidos() {
        System.out.println("\n--- TESTE: ListaDeAtendidos ---");
        ListaDeAtendidos lista = new ListaDeAtendidos();

        lista.adicionarAtendido(new Paciente("Ana Costa", 72, "456.789.012-34"));
        lista.adicionarAtendido(new Paciente("Carlos Mendes", 28, "567.890.123-45"));

        lista.exibirAtendidos();
        lista.exibirRelatorio();
    }
}
