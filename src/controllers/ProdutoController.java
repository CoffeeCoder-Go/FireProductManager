/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import configuration.DatabaseTypes;
import configuration.EventManager;
import entity.Produto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import dao.ProdutosDAO;
import entity.EventType;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cliente
 */
public class ProdutoController {
    
    private ProdutosDAO dao;
    
    public ProdutoController(DatabaseTypes dao){
        this.dao = dao.get();
    }
    
    public ProdutoController(ProdutosDAO dao){
        this.dao = dao;
    }
    
    public void listAll(DefaultTableModel model){
        try{
            List<Produto> products = dao.getAll();
        
            model.setNumRows(0);



            for(Produto produto : products){

                model.addRow(new Object[]{ produto.getId(),produto.getNome(),produto.getQuantidade(),produto.getPrecoUnidade()});
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
        }
    }
    
    public void create(Produto produto){
        try{
            

            
            
            
            dao.create(produto);
        }catch(SQLException | RuntimeException e){
            
            JOptionPane.showMessageDialog(null, "Não foi possível criar por causa de:"+e.getMessage(), "erro", 0);
        }
    }
    
    public void searchByName(DefaultTableModel model,String nome){
        try{
            List<Produto> products = dao.searchByName(nome);
        
            model.setNumRows(0);

            for(Produto produto : products){

                model.addRow(new Object[]{ produto.getId(),produto.getNome(),produto.getQuantidade(),produto.getPrecoUnidade()});
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível criar por causa de:"+e.getMessage(), "erro", 0);
        }
    }
    
   public void update(Long id,Produto produto){
       try{
           dao.update(id, produto);
           EventManager.add("Produto atualizado com sucesso!", EventType.UPDATE);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Não foi possível criar por causa de:"+e.getMessage(), "erro", 0);
       }
       
   }
   
   public void delete(Long id){
       try{
           dao.delete(id);
       
           EventManager.add("Produto deletado com sucesso", EventType.DELETE);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Não foi possível criar por causa de:"+e.getMessage(), "erro", 0);
       }
   }
}
