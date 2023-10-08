package com.projeto.livraria.model;

import java.time.LocalDateTime;
import java.util.List;

public class Compra {
    private String descricao;
    private LocalDateTime data;
    private boolean finalizadaComSucesso;
    private Cliente cliente;
    private List<Produto> produtos;

    public Compra() {
        descricao = "Você iniciou suas compras!";
        data = LocalDateTime.now();
        finalizadaComSucesso = true;
    }

    public Compra(String decricao, Cliente cliente, List<Produto> produtos) {
        this();
        this.descricao = decricao;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isFinalizadaComSucesso() {
        return finalizadaComSucesso;
    }

    public void setFinalizadaComSucesso(boolean finalizadaComSucesso) {
        this.finalizadaComSucesso = finalizadaComSucesso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return descricao + ";" + data + ";" + finalizadaComSucesso + ":" +
                cliente + ";" + produtos.size();
    }
}
