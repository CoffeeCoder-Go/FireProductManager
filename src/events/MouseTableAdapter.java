/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import entity.Produto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import view.ProdutoDetails;

/**
 *
 * @author cliente
 */
public class MouseTableAdapter extends MouseAdapter{
    public JTable jTable;
    
    public MouseTableAdapter(JTable jTable){
        this.jTable = jTable;
    }
            
    @Override
    public void mousePressed(MouseEvent me) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        
        if(me.getClickCount() == 2){
            int row = jTable.getSelectedRow();
                 
            if(row != -1){
                Long id = (Long) jTable.getValueAt(row, 0);
                String nome = (String) jTable.getValueAt(row, 1);
                Integer quantidade = (Integer) jTable.getValueAt(row, 2);
                Float precoPorUnidade = (Float) jTable.getValueAt(row, 3);


                Produto produto = new Produto(id,nome,quantidade,precoPorUnidade);

                ProdutoDetails details = new ProdutoDetails(produto);

                details.setVisible(true);


            }
        }
        
                
    }
}
