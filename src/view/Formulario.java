/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controllers.ProdutoController;
import dao.MySQLProdutosDAO;
import entity.Produto;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cliente
 */
// Classe
public class Formulario extends javax.swing.JFrame {
    
    // Controller
    private final ProdutoController controller;
    
    
    
    
    
    
    
    


    public Formulario() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controller = new ProdutoController(new MySQLProdutosDAO());
        
  
        
    }

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        minus = new javax.swing.JButton();
        quantidaddeTexto = new javax.swing.JLabel();
        more = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        precoPorUnidade = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulário");
        setResizable(false);

        nome.setMinimumSize(new java.awt.Dimension(120, 100));
        nome.setPreferredSize(new java.awt.Dimension(120, 25));
        nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomeFocusLost(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("Quantidade");

        minus.setText("<");
        minus.addActionListener(this::minusActionPerformed);

        quantidaddeTexto.setText("0");

        more.setText(">");
        more.addActionListener(this::moreActionPerformed);

        jLabel3.setText("Preço por Unidade");

        precoPorUnidade.setMinimumSize(new java.awt.Dimension(120, 25));
        precoPorUnidade.setPreferredSize(new java.awt.Dimension(120, 25));
        precoPorUnidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                precoPorUnidadeFocusLost(evt);
            }
        });

        save.setBackground(new java.awt.Color(51, 51, 255));
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Salvar");
        save.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        save.addActionListener(this::saveActionPerformed);

        exit.setBackground(new java.awt.Color(255, 51, 51));
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("Sair");
        exit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 3, true));
        exit.addActionListener(this::exitActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidaddeTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(more, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoPorUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(minus)
                    .addComponent(quantidaddeTexto)
                    .addComponent(more))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(precoPorUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(exit))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed

        int number = Integer.parseInt(quantidaddeTexto.getText());
        
        if(number > 0) --number;
        
        quantidaddeTexto.setText(Integer.toString(number));
        
    }//GEN-LAST:event_minusActionPerformed

    
    
    
    
    
    
    private void moreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreActionPerformed

        int number = Integer.parseInt(quantidaddeTexto.getText());
        
        ++number;
        
        quantidaddeTexto.setText(Integer.toString(number));
        
    }//GEN-LAST:event_moreActionPerformed

    
    
    
    
    
    
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed

        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    
    
    
    
    
    
    
    
    
    
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try{
            Produto produto = new Produto();
            produto.setNome(nome.getText());
            produto.setPrecoUnidade(Float.valueOf(precoPorUnidade.getText()));
            produto.setQuantidade(Integer.valueOf(quantidaddeTexto.getText()));
            controller.create(produto);

            
            nome.setText("");
            quantidaddeTexto.setText("0");
            precoPorUnidade.setText("");
            
   
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
        }
    }//GEN-LAST:event_saveActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    
    
    private void nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeFocusLost

    }//GEN-LAST:event_nomeFocusLost

    
    
    
    
    
    
    
    
    
    
    
    
    
    private void precoPorUnidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precoPorUnidadeFocusLost

    }//GEN-LAST:event_precoPorUnidadeFocusLost


    
    
    
    
    
    
    
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Formulario().setVisible(true));
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton minus;
    private javax.swing.JButton more;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField precoPorUnidade;
    private javax.swing.JLabel quantidaddeTexto;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
