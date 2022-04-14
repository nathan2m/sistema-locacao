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
public class Cliente {

    private Integer Id;
    private String Nome;
    private String CPF;
    private Date DataNascimento;

    public Cliente() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public String getDataNascimentoFormatado() {
        return DataNascimento != null ? new SimpleDateFormat("yyyy-MM-dd").format(DataNascimento) : "";
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }
}
