package javafxmvc.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Venda implements Serializable {

    private int cdVenda;
    private LocalDate data;
    private double valor;
    private boolean personalizado;
    private String descricao;
    private List<ItemDeVenda> itensDeVenda;
    private Cliente cliente;
    private Vendedor vendedor;
    public Venda() {
    }

    public Venda(int cdvenda, LocalDate data, double valor) {
        this.cdVenda = cdvenda;
        this.data = data;
        this.valor = valor;
       
    }
    public Venda(int cdvenda, Cliente cliente, Vendedor vendedor, double valor) {
        this.cdVenda = cdvenda;
        //this.data = data;
        this.valor = valor;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }
    public Venda(int cdvenda, Cliente cliente, Vendedor vendedor, double valor, boolean personalizado, String descricao) {
        this.cdVenda = cdvenda;
        //this.data = data;
        this.valor = valor;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.personalizado = personalizado;
        this.descricao = descricao;
    }
    public void setPersonalizado(boolean flag){
        personalizado = flag;
    }
    public boolean getPersonalizado(boolean flag){
        return personalizado;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }

    public int getCdVenda() {
        return cdVenda;
    }

    public void setCdVenda(int cdVenda) {
        this.cdVenda = cdVenda;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public List<ItemDeVenda> getItensDeVenda() {
        return itensDeVenda;
    }

    public void setItensDeVenda(List<ItemDeVenda> itensDeVenda) {
        this.itensDeVenda = itensDeVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
}
