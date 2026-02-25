/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import configuration.EventManager;
import controllers.ProdutoController;
import dao.MySQLProdutosDAO;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cliente
 */
public class InitialPage extends javax.swing.JFrame {
    
    private final ProdutoController controller;

    
    
    
    
    
    
    
    
    
    
    public InitialPage() {
        initComponents();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
                
                if(opcao == JOptionPane.YES_OPTION){
                    
                    
                    System.exit(0);
                }
            }
        });
        
        controller = new ProdutoController(new MySQLProdutosDAO());
        
        visualConfig();
        
        onStart();
        
        onUpdate();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void onUpdate(){
        
        Timer timer = new Timer(1,new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    while(!EventManager.isEmpty()){
                        reloadTable();
                        
                        EventManager.delete();
                    }
                    
                }
                
            }
                
        );
        
        timer.start();
    }
    
    
    
    
    public void reloadTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        controller.listAll(model);
    }
    
    
    
    
    
    
    public void reloadTable(String nome){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        controller.searchByName(model, nome);
    }
    
    
    
    
    private void onStart(){
        reloadTable();
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    private void visualConfig(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            
        int largura = dimension.width;
        int altura = dimension.height;
        int x = (largura - this.getWidth())/2;
        int y = (altura - this.getHeight())/2;
        this.setLocation(x,y);
        this.setSearchExistent(false);
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        create = new javax.swing.JMenu();
        goToForm = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        pesquisar = new javax.swing.JMenu();
        enableSearch = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("All Products");
        setResizable(false);
        setSize(new java.awt.Dimension(1300, 1280));

        search.setText("...");
        search.setActionCommand("<Not Set>");
        search.setMinimumSize(new java.awt.Dimension(300, 25));
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Nome", "Quantidade", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        create.setText("Dados");

        goToForm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        goToForm.setText("Registrar");
        goToForm.addActionListener(this::goToFormActionPerformed);
        create.add(goToForm);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem1.setText("Atualizar");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        create.add(jMenuItem1);

        menu.add(create);

        pesquisar.setText("Pesquisar");

        enableSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        enableSearch.setText("Caixa");
        enableSearch.addActionListener(this::enableSearchActionPerformed);
        pesquisar.add(enableSearch);

        menu.add(pesquisar);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    
    
    
    private void goToFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToFormActionPerformed

        
        Formulario formulario = new Formulario();
        
        formulario.setVisible(true);
        
    }//GEN-LAST:event_goToFormActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void enableSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableSearchActionPerformed

    
        long inicio = System.currentTimeMillis();

        this.setSearchExistent(!getSearchExistent());

        long fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) + "ms");
    }//GEN-LAST:event_enableSearchActionPerformed

    
    
    
    
    
    
    
    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained

        if(this.search.getText().equals("...")){
            this.search.setText("");
        }
    }//GEN-LAST:event_searchFocusGained

    
    
    
    
    
    
    
    
    
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        this.controller.listAll(model);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            reloadTable(search.getText());
        }
        
    
    }//GEN-LAST:event_searchKeyPressed

    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            InitialPage initPage = new InitialPage();
            initPage.setVisible(true);
            
            
        });
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void setSearchExistent(boolean b){
        this.search.setVisible(b);
        this.revalidate();
        this.repaint();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean getSearchExistent(){
        return this.search.isVisible();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu create;
    private javax.swing.JMenuItem enableSearch;
    private javax.swing.JMenuItem goToForm;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu pesquisar;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
