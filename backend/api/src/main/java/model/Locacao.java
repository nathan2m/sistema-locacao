/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nathan
 */
public class Locacao {
    private Integer Id;
    private Cliente Cliente;
    private Filme Filme;
    private Date DataLocacao;
    private Date DataDevolucao;

    public Locacao() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Filme getFilme() {
        return Filme;
    }

    public void setFilme(Filme Filme) {
        this.Filme = Filme;
    }

    public Date getDataLocacao() {
        return DataLocacao;
    }

    public String getDataLocacaoFormatado() {
        return DataLocacao != null ? new SimpleDateFormat("yyyy-MM-dd").format(DataLocacao) : "";
    }

    public void setDataLocacao(Date DataLocacao) {
        this.DataLocacao = DataLocacao;
    }

    public Date getDataDevolucao() {
        return DataDevolucao;
    }

    public String getDataDevolucaoFormatado() {
        return DataDevolucao != null ? new SimpleDateFormat("yyyy-MM-dd").format(DataDevolucao) : "";
    }

    public void setDataDevolucao(Date DataDevolucao) {
        this.DataDevolucao = DataDevolucao;
    }
}
