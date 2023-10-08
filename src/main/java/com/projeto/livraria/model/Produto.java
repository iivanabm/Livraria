package com.projeto.livraria.model;

public abstract class Produto {

    private Integer codigo;
    private String nome;
    private float valor;

    public Produto() {}

    public Produto(Integer codigo, String nome, float valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %.2f", codigo, nome, valor);
    }
}
