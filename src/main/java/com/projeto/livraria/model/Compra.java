package com.projeto.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra {

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "finalizada_com_sucesso")
    private boolean finalizadaComSucesso;

    @ManyToOne
    @Column(name = "cliente")
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
