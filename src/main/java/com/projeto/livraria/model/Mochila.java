package com.projeto.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mochila")
public class Mochila extends Produto {

    @Column(name = "marca")
    private String marca;

    @Column(name = "cor")
    private String cor;

    @Column(name = "escolar")
    private boolean escolar;

    public Mochila() {
    }

    public Mochila(Integer codigo, String nome, float valor, String marca, String cor, boolean escolar) {
        super(codigo, nome, valor);
        this.marca = marca;
        this.cor = cor;
        this.escolar = escolar;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isEscolar() {
        return escolar;
    }

    public void setEscolar(boolean escolar) {
        this.escolar = escolar;
    }
}
