package com.projeto.livraria.model;

public class Caderno extends Produto{

    private String materias;
    private boolean capaDura;

    private String marca;

    public Caderno() {

    }

    public Caderno(Integer codigo, String nome, float valor, String materias, boolean capaDura, String marca) {
        super(codigo, nome, valor);
        this.materias = materias;
        this.capaDura = capaDura;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s",
                super.toString(),
                materias, capaDura, marca);
    }

    public String getMaterias() {
        return materias;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }

    public boolean isCapaDura() {
        return capaDura;
    }

    public void setCapaDura(boolean capaDura) {
        this.capaDura = capaDura;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
