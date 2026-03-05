/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import configuration.DatabaseTypes;
import configuration.EventManager;
import controllers.ProdutoController;
import dao.MySQLProdutosDAO;
import entity.Produto;
import events.MouseTableAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
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
        
        // Seta um icone
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("resources/assets/logo.png"));
        
        this.setIconImage(icon.getImage());
        
        // Seta pra não fazer nada ao fechar
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        // Algoritmo para garantir desejo do usuário
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
                
                if(opcao == JOptionPane.YES_OPTION){
                    
                    
                    System.exit(0);
                }
            }
        });
        
        // Chama o controlador que vai usar MySQL
        controller = new ProdutoController(DatabaseTypes.MYSQL);
        
        // Chama configuração visual
        visualConfig();
        
        // Ao iniciar
        onStart();
        
        // Ao atualizar
        onUpdate();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void onUpdate(){
        
        // Realiza a cada 1 segundo
        Timer timer = new Timer(1,new ActionListener() {
            
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    // Atualiza a tabela se houver evento ainda
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
        // Captura modelo da tabela
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Passa o modelo para o listador do controller
        controller.listAll(model);
        
        // Adiciona eventos de mouse
        jTable1.addMouseListener(new MouseTableAdapter(jTable1));
        
    }
    
    
    
    
    
    // Se houver pesquisa também
    public void reloadTable(String nome){
        // Captura modelo da tabela
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Passa o modelo para o procurador do controller
        controller.searchByName(model, nome);
        
        // Adiciona eventos de mouse
        jTable1.addMouseListener(new MouseTableAdapter(jTable1));
    }
    
    
    
    
    private void onStart(){
        // Recarrega a tabela toda vez que iniciar
        reloadTable();
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    // Configuração visual
    private void visualConfig(){
        // Coloca no meio
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            
        int largura = dimension.width;
        int altura = dimension.height;
        int x = (largura - this.getWidth())/2;
        int y = (altura - this.getHeight())/2;
        this.setLocation(x,y);
        this.setSearchExistent(false);// Torna pesquisa invisivel
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
        restart = new javax.swing.JMenuItem();
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

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.black));
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

        menu.setBackground(new java.awt.Color(0, 0, 255));
        menu.setBorder(null);
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setBorderPainted(false);
        menu.setOpaque(true);

        create.setBackground(new java.awt.Color(0, 51, 255));
        create.setBorder(null);
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setText("Dados");
        create.setBorderPainted(false);

        goToForm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        goToForm.setBackground(new java.awt.Color(0, 51, 255));
        goToForm.setForeground(new java.awt.Color(255, 255, 255));
        goToForm.setText("Registrar");
        goToForm.addActionListener(this::goToFormActionPerformed);
        create.add(goToForm);

        restart.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        restart.setBackground(new java.awt.Color(0, 51, 255));
        restart.setForeground(new java.awt.Color(255, 255, 255));
        restart.setText("Atualizar");
        restart.addActionListener(this::restartActionPerformed);
        create.add(restart);

        menu.add(create);

        pesquisar.setBackground(new java.awt.Color(0, 51, 255));
        pesquisar.setForeground(new java.awt.Color(255, 255, 255));
        pesquisar.setText("Pesquisar");

        enableSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        enableSearch.setBackground(new java.awt.Color(0, 51, 255));
        enableSearch.setForeground(new java.awt.Color(255, 255, 255));
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

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Viabiliza pesquisa
    private void enableSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableSearchActionPerformed

    
        long inicio = System.currentTimeMillis();

        this.setSearchExistent(!getSearchExistent());

        long fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) + "ms");
    }//GEN-LAST:event_enableSearchActionPerformed

    
    
    
    
    
    
    // Toda fez que ganhar foco, limpa os . da pesquisa
    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained

        if(this.search.getText().equals("...")){
            this.search.setText("");
        }
    }//GEN-LAST:event_searchFocusGained
    
    // Atualiza a tabela manualmente
    private void restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        this.controller.listAll(model);
    }//GEN-LAST:event_restartActionPerformed

    // Se pressionar enter pesquisa
    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            reloadTable(search.getText());
        }
        
    
    }//GEN-LAST:event_searchKeyPressed
    
    // Vai pro formulário de pesquisa
    private void goToFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToFormActionPerformed

        Formulario formulario = new Formulario();

        formulario.setVisible(true);

    }//GEN-LAST:event_goToFormActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    // Chama a página
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            InitialPage initPage = new InitialPage();
            initPage.setVisible(true);
            
            
        });
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Viabiliza a pesquisa
    public void setSearchExistent(boolean b){
        this.search.setVisible(b);
        this.revalidate();
        this.repaint();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Retorna estado da pesquisa
    public boolean getSearchExistent(){
        return this.search.isVisible();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu create;
    private javax.swing.JMenuItem enableSearch;
    private javax.swing.JMenuItem goToForm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu pesquisar;
    private javax.swing.JMenuItem restart;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
