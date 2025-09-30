package org.estruturaDados.model;

public class Paciente {
    private String nome;
    private int idade;
    private boolean urgente;
    private boolean prioridade;
    private String cpf;

    // Construtor completo
    public Paciente(String nome, int idade, String cpf, boolean prioridade, boolean urgente) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.prioridade = prioridade;
        this.urgente = urgente;
    }

    // Construtor sem 'urgente'
    public Paciente(String nome, int idade, String cpf, boolean prioridade) {
        this(nome, idade, cpf, prioridade, false);
    }

    // Construtor padrão: prioridade automática por idade (>=60)
    public Paciente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.urgente = false;
        this.prioridade = idade >= 60;
    }

    public Paciente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Alias usado pelo Main
    public boolean temPrioridade() {
        return this.prioridade;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", urgente=" + urgente +
                ", prioridade=" + prioridade +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
