package com.projeto.livraria.model;

public class Livro extends Produto {

    private Boolean capaDura;
    private String autor;
    private String editora;

    public Livro() {}

    public Livro(Integer codigo, String nome, float valor, Boolean capaDura, String autor, String editora) {
        super(codigo, nome, valor);
        this.capaDura = capaDura;
        this.autor = autor;
        this.editora = editora;
    }

    @Override
    public String toString() {
        return String.format("%s; %s; %s; %s",
                super.toString(),
                capaDura, autor, editora);
    }
}
