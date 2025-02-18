package com.exemplo.funcionarios;

public class Funcionario {

    private Long id;
    private String nome;
    private String designacao;
    private Double salario;
    private String numeroTelefone;
    private String endereco;

    // Construtores, getters e setters

    public Funcionario(Long id, String nome, String designacao, Double salario, String numeroTelefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.designacao = designacao;
        this.salario = salario;
        this.numeroTelefone = numeroTelefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
