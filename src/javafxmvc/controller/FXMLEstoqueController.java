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
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafxmvc.model.domain.ItemDeVenda;
import javafxmvc.model.domain.Produto;

/**
 * FXML Controller class
 *
 * @author joana
 */
public class FXMLEstoqueController implements Initializable {

    private           List<Produto> produtoList = new ArrayList<>();
    private ObservableList<Produto> produtoObservableList;
    @FXML
    private ComboBox<Produto> comboBoxProduto;
    @FXML
    private TextField textfieldQuantidade;
     
    private List<Produto> estoqueList = new ArrayList<>();
    private ObservableList<Produto> estoqueListObservableList;
    @FXML
    private TableView<Produto> tableViewProduto;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutoNome;
    @FXML
    private TableColumn<Produto, Integer> tableColumnProdutoQuantidade;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        produtoList.add(new Produto(0,"Box Articulado de banheiro",500.0,0,"Fazer com altura de 2.10 metros"));
        produtoList.add(new Produto(0,"Box de correr de banheiro",100.0,0,"Fazer com vidro temperado"));
        produtoList.add(new Produto(0,"Vidro temperado para janela",1000.0,0,"Fazer com vidro de cor fosca"));
        produtoList.add(new Produto(0,"Vidro para janela 100cm",1000.0,0,"Fazer com vidro de cor branca"));
        produtoList.add(new Produto(0,"Vidro para janela 30cm",1000.0,0,"Fazer com vidro fosco"));
        produtoList.add(new Produto(0,"Espelho de banheiro 15 cm",1000.0,0,"Fazer em formato oval 15 por 20"));
        produtoObservableList = FXCollections.observableArrayList(produtoList);
        comboBoxProduto.setItems(produtoObservableList);
        
        estoqueList.add(new Produto(0,"Box Articulado de banheiro",500.0,10,"Fazer com altura de 2.10 metros"));
        estoqueList.add(new Produto(0,"Box de correr de banheiro",100.0,5,"Fazer com vidro temperado"));
        estoqueList.add(new Produto(0,"Vidro temperado para janela",1000.0,2,"Fazer com vidro de cor fosca"));
        estoqueListObservableList = FXCollections.observableArrayList(estoqueList);
        
        tableColumnProdutoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnProdutoQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tableViewProduto.setItems(estoqueListObservableList);
        
    }    
    @FXML
    private void handleAdicionar(){
        Produto p = comboBoxProduto.getSelectionModel().getSelectedItem();
        p.setQuantidade(Integer.parseInt(textfieldQuantidade.getText()));
        int i =0;
        boolean flag = false;
        for(Produto pEstoque: estoqueListObservableList){
            
            if(p.getNome() == pEstoque.getNome()){
                int qnt = p.getQuantidade();
               
                
                estoqueListObservableList.get(i).addQuantidade(qnt);
                flag = true;
            }
            i++;
        }
        if(!flag){
            
            estoqueListObservableList.add(p);
        }
        
        tableViewProduto.refresh();
    }
    @FXML
    private void handleRemover(){
        Produto p = comboBoxProduto.getSelectionModel().getSelectedItem();
        p.setQuantidade(Integer.parseInt(textfieldQuantidade.getText()));
        int i =0;
        boolean flag = false;
        for(Produto pEstoque: estoqueListObservableList){
            
            if(p.getNome() == pEstoque.getNome()){
                int qnt = p.getQuantidade();
               
                
                estoqueListObservableList.get(i).addQuantidade(-qnt);
                if(estoqueListObservableList.get(i).getQuantidade() == 0){
                    estoqueListObservableList.remove(i);
                }
                flag = true;
            }
            i++;
        }
        
        
        tableViewProduto.refresh();
    }
}
