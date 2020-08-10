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

/**
 * FXML Controller class
 *
 * @author llcos_000
 */
public class FXMLCadastroFuncionarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private           List<String> setorList  = new ArrayList<>();
    private ObservableList<String> setorObservableList;
    @FXML
    private ComboBox<String> comboBoxSetor;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setorList.add(new String("Setor de compras"));
        setorList.add(new String("Setor de produção"));
        setorList.add(new String("Setor de vendas"));
        setorObservableList = FXCollections.observableArrayList(setorList);
        comboBoxSetor.setItems(setorObservableList);
    }    
    
}
