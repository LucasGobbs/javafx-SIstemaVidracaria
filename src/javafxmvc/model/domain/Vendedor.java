/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc.model.domain;

/**
 *
 * @author llcos_000
 */

import java.io.Serializable;

public class Vendedor implements Serializable {

    private int cdCliente;
    private String nome;
    private String cpf;
    private String telefone;

    public Vendedor(){
    }
    
    public Vendedor(int cdCliente, String nome, String cpf) {
        this.cdCliente = cdCliente;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getCdVendedor() {
        return cdCliente;
    }

    public void setCdVendedor(int cdCliente) {
        this.cdCliente = cdCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}