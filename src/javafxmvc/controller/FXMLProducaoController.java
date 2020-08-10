/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxmvc.model.domain.Cliente;
import javafxmvc.model.domain.ItemDeVenda;
import javafxmvc.model.domain.Produto;
import javafxmvc.model.domain.Venda;
import javafxmvc.model.domain.Vendedor;

/**
 * FXML Controller class
 *
 * @author llcos_000
 */
public class FXMLProducaoController implements Initializable {
 
    private List<Venda> vendaList = new ArrayList<>();
    private ObservableList<Venda> vendaObservableList;
    @FXML
    private TableView<Venda> tableViewVenda;
    @FXML
    private TableColumn<Venda, Integer> tableColumnVendaId;
    @FXML
    private TableColumn<Venda, String> tableColumnVendaCliente;
    @FXML
    private TableColumn<Venda, String> tableColumnVendaVendedor;

    
    
    private List<ItemDeVenda> itemList = new ArrayList<>();
    private ObservableList<ItemDeVenda> itemObservableList;
    @FXML
    private TableView<ItemDeVenda> tableViewItem;
    @FXML
    private TableColumn<ItemDeVenda, String> tableColumnItemNome;
    @FXML
    private TableColumn<ItemDeVenda, Integer> tableColumnItemQuantidade;
    
    @FXML
    private void handleVendaSelection(Venda venda){
        System.out.println();
        itemList = new ArrayList<>();
        for(ItemDeVenda i: venda.getItensDeVenda()){
            if(!i.getProduto().getPersonalizado()){
                itemList.add(i); 
            }
        }
       
        itemObservableList = FXCollections.observableArrayList(itemList);
        tableViewItem.setItems(itemObservableList);
        tableViewItem.refresh();
    }
    @FXML
    private void handleAcionarProducao(){
        Venda v = tableViewVenda.getSelectionModel().getSelectedItem();
        vendaObservableList.remove(v);
        Alert alertA = new Alert(Alert.AlertType.INFORMATION);
        alertA.setTitle("Action");
        alertA.setHeaderText("Encomenda pronta para ser entregue");
        alertA.setContentText("Entrando em contato com o cliente, para o envio da encomenda");
        alertA.show();
        tableViewVenda.refresh();
    }
    @FXML
    private void handleComprarProduto(){
        ItemDeVenda i = tableViewItem.getSelectionModel().getSelectedItem();
        Alert alertA = new Alert(Alert.AlertType.INFORMATION);
        alertA.setTitle("Action");
        alertA.setHeaderText("Requisitando o produto: " + i.getProduto().getNome());
        alertA.setContentText("Entrando em contato com o estoque");
        alertA.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(0,"Box Articulado de banheiro",500.0,0,"Fazer com altura de 2,10 metros"));
        produtos.add(new Produto(0,"Box de correr de banheiro",100.0,0));
        produtos.add(new Produto(0,"Vidro temperado para janela",1000.0,0));
        
        produtos.add(new Produto(0,"Teste",1000.0,0));
        
        
        List<Vendedor> vendedores = new ArrayList<>();
        vendedores.add(new Vendedor(0,"João Cleber","132.321.125-13"));
        vendedores.add(new Vendedor(0,"Jorge da Silva","111.354.117-67"));
        vendedores.add(new Vendedor(0,"Clayton da Cunha","221.377.167-22"));
        
        List<Cliente> clientes = new ArrayList<>();
        
        clientes.add(new Cliente(0,"Joãozin Albuquerque","111.222.333-13"));
        clientes.add(new Cliente(0,"Lucas Costa","333.444.773-23"));
        clientes.add(new Cliente(0,"Joana rozaes","333.444.773-23"));
        Venda a = new Venda(0,clientes.get(0),vendedores.get(0),10);
        List<ItemDeVenda> a_itens = new ArrayList<>();
        a_itens.add(new ItemDeVenda(produtos.get(0),1));
        a_itens.add(new ItemDeVenda(produtos.get(1),5));
        a.setItensDeVenda(a_itens);
        {
            float soma = 0;
            for(ItemDeVenda item: a.getItensDeVenda()){
                soma += item.getValor() * item.getQuantidade();
            }
            a.setValor(soma);
        }
        
        Venda b = new Venda(0,clientes.get(1),vendedores.get(2),10);
        List<ItemDeVenda> b_itens = new ArrayList<>();
        b_itens.add(new ItemDeVenda(produtos.get(1),5));
        b_itens.add(new ItemDeVenda(produtos.get(2),0));
        b.setItensDeVenda(b_itens);
        {
            float soma = 0;
            for(ItemDeVenda item: b.getItensDeVenda()){
                soma += item.getValor() * item.getQuantidade();
            }
            b.setValor(soma);
        }
        
        Venda c = new Venda(0,clientes.get(2),vendedores.get(1),10);
        List<ItemDeVenda> c_itens = new ArrayList<>();
       
        c_itens.add(new ItemDeVenda(produtos.get(3),0));
        c.setItensDeVenda(c_itens);
        {
            float soma = 0;
            for(ItemDeVenda item: c.getItensDeVenda()){
                soma += item.getValor() * item.getQuantidade();
            }
            c.setValor(soma);
        }
        
        vendaList.add(a);
        vendaList.add(b);
        vendaList.add(c);
        vendaObservableList = FXCollections.observableArrayList(vendaList);
        
        tableColumnVendaId.setCellValueFactory(new PropertyValueFactory<>("cdVenda"));
        tableColumnVendaCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        tableColumnVendaVendedor.setCellValueFactory(new PropertyValueFactory<>("vendedor"));
        tableViewVenda.setItems(vendaObservableList);
        
        tableViewVenda.getSelectionModel()  
			   .selectedItemProperty()  
			   .addListener((observable, oldValue, newValue)  
			    ->handleVendaSelection(newValue));  //
        
        
        tableColumnItemNome.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tableColumnItemQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        itemObservableList = FXCollections.observableArrayList(itemList);
        tableViewItem.setItems(itemObservableList);
    }      
}
