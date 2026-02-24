/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import configuration.EventManager;
import entity.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import dao.ProdutosDAO;
import entity.EventType;

/**
 *
 * @author cliente
 */
public class ProdutoController {
    
    private ProdutosDAO dao;
    
    public ProdutoController(ProdutosDAO dao){
        this.dao = dao;
    }
    
    public void listAll(DefaultTableModel model){
        List<Produto> products = dao.getAll();
        
        model.setNumRows(0);
        
        for(Produto produto : products){
            
            model.addRow(new Object[]{ produto.getId(),produto.getNome(),produto.getQuantidade(),produto.getPrecoUnidade()});
        }
    }
    
    public void create(Produto produto){
        dao.create(produto);
        EventManager.add("Creation of produto "+produto.getNome(),EventType.CREATE);
    }
    
    public void searchByName(DefaultTableModel model,String nome){
        List<Produto> products = dao.searchByName(nome);
        
        model.setNumRows(0);
        
        for(Produto produto : products){
            
            model.addRow(new Object[]{ produto.getId(),produto.getNome(),produto.getQuantidade(),produto.getPrecoUnidade()});
        }
    }
}
