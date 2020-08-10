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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxmvc.model.domain.Cliente;
import javafxmvc.model.domain.Produto;
import javafxmvc.model.domain.Vendedor;

/**
 * FXML Controller class
 *
 * @author llcos_000
 */
public class FXMLCadastroVendaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private           List<Produto> itemList = new ArrayList<>();
    private ObservableList<Produto> itemObservableList;
    @FXML
    private ComboBox<Produto> comboBoxItem;
    @FXML
    private TextField textfieldQuantidade;
    
    @FXML
    private Label precoTotal;
    
    @FXML
    private CheckBox personalizado;
    @FXML
    private TextField descricao;
    
    private List<Produto> carrinhoList = new ArrayList<>();
    private ObservableList<Produto> carrinhoObservableList;
    @FXML
    private TableView<Produto> tableViewProduto;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutoNome;
    @FXML
    private TableColumn<Produto, Double> tableColumnProdutoPreco;
    @FXML
    private TableColumn<Produto, Integer> tableColumnProdutoQuantidade;
    
    @FXML
    private void handleAdicionar(){
        Produto p = comboBoxItem.getSelectionModel().getSelectedItem();
        p.setQuantidade(Integer.parseInt(textfieldQuantidade.getText()));
        if(personalizado.selectedProperty().getValue()){
            p.setPersonalizado(true);
            p.setDescricao(descricao.getText());
            carrinhoObservableList.add(p);
        }else{
            carrinhoObservableList.add(p);
        }       
    
        calcularTotal();
   
    }
    @FXML
    private void handleFinalizar(){
             
        Alert alertA = new Alert(Alert.AlertType.INFORMATION);
        alertA.setTitle("Action");
        alertA.setHeaderText("Encomenda registrada");
        alertA.setContentText("Enviando dados para os setores");
        alertA.show();
        
    }
    @FXML
    private void handleCancelar(){
        Alert alertA = new Alert(Alert.AlertType.WARNING);
        alertA.setTitle("Action");
        alertA.setHeaderText("Operação Cancelada");
        //alertA.setContentText("Enviando dados para os setores");
        alertA.show();
    }
    @FXML
    private void handleRemover(){
        Produto p = tableViewProduto.getSelectionModel().getSelectedItem();
        carrinhoObservableList.remove(p);
        
        calcularTotal();
    }
    private void calcularTotal(){
        float soma = 0;
        for(Produto item: carrinhoObservableList){
            soma += item.getPreco() * item.getQuantidade();
        }
        precoTotal.setText(String.format("%.2f", soma));
        
    }
    
    private           List<Vendedor> vendedorList = new ArrayList<>();
    private ObservableList<Vendedor> vendedorObservableList;
    @FXML
    private ComboBox<Vendedor> comboBoxVendedor;
    
    private           List<Cliente> clienteList = new ArrayList<>();
    private ObservableList<Cliente> clienteObservableList;
    @FXML
    private ComboBox<Cliente> comboBoxCliente;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
  
        itemList.add(new Produto(0,"Box Articulado de banheiro",1200.0,10));
        itemList.add(new Produto(0,"Box de correr de banheiro",1000.0,10));
        itemList.add(new Produto(0,"Vidro temperado para janela",400.0,10));
        itemList.add(new Produto(0,"Vidro para janela 100cm",200.0,10));
        itemList.add(new Produto(0,"Vidro para janela 30cm",200.0,10));
        itemList.add(new Produto(0,"Espelho de banheiro 15 cm",50.0,10));
        itemObservableList = FXCollections.observableArrayList(itemList);
        comboBoxItem.setItems(itemObservableList);
        
        tableColumnProdutoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnProdutoPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableColumnProdutoQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        carrinhoObservableList = FXCollections.observableArrayList(carrinhoList);
        tableViewProduto.setItems(carrinhoObservableList);
        
        vendedorList.add(new Vendedor(0,"João Cleber","132.321.125-13"));
        vendedorList.add(new Vendedor(0,"Jorge da Silva","111.354.117-67"));
        vendedorList.add(new Vendedor(0,"Clayton da Cunha","221.377.167-22"));
        vendedorObservableList = FXCollections.observableArrayList(vendedorList);
        comboBoxVendedor.setItems(vendedorObservableList);
        
        clienteList.add(new Cliente(0,"Joãozin Albuquerque","111.222.333-13"));
        clienteList.add(new Cliente(0,"Lucas Costa","333.444.773-23"));
        clienteObservableList = FXCollections.observableArrayList(clienteList);
        comboBoxCliente.setItems(clienteObservableList);
        
        
    }

   

    
}
