/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nathan
 */
public class Filme {
    private Integer Id;
    private String Titulo;
    private Integer ClassificacaoIndicativa;
    private Integer Lancamento;

    public Filme() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public Integer getClassificacaoIndicativa() {
        return ClassificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(Integer ClassificacaoIndicativa) {
        this.ClassificacaoIndicativa = ClassificacaoIndicativa;
    }

    public Integer getLancamento() {
        return Lancamento;
    }

    public void setLancamento(Integer Lancamento) {
        this.Lancamento = Lancamento;
    }
}
