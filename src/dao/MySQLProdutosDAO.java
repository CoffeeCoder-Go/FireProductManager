/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Produto;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author cliente
 */
public class MySQLProdutosDAO implements ProdutosDAO{
    public Connection DB;
    
    public MySQLProdutosDAO(Connection db){
        this.DB = db;
    }

    @Override
    public void create(Produto produto) {
        String sql = "INSERT INTO produtos(nome,quantidade,precoPorUnidade) VALUES (?,?,?)";
        
        try{
            PreparedStatement pstm = DB.prepareStatement(sql);
            
            pstm.setString(1, produto.getNome());
            pstm.setInt(2, produto.getQuantidade());
            pstm.setFloat(3, produto.getPrecoUnidade());
            
            pstm.execute();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível criar por causa de:"+e.getMessage(), "erro", 0);
        }
    }

    @Override
    public List<Produto> getAll() {
        List<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM produtos";
        
        try{
            PreparedStatement ps = DB.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getFloat("precoPorUnidade")
                );
                
                produtos.add(produto);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível listar por causa de:"+e.getMessage(), "erro", 0);
            
            
            return null;
        }
        
        return produtos;
    }

    @Override
    public List<Produto> searchByName(String name) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
        
        try{
            PreparedStatement pstmt = DB.prepareStatement(sql);
            
            pstmt.setString(1, name+"%");
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getFloat("precoPorUnidade")
                );
                
                produtos.add(produto);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível listar por causa de "+e.getMessage(), "Erro", 0);
            
            return null;
        }
        
        return produtos;
    }

    @Override
    public Produto getById(Long id) {
        Produto produto;
        String sql = "SELECT * FROM produtos WHERE id=?";
        
        try{
            PreparedStatement pstmt = DB.prepareStatement(sql);
            
            pstmt.setLong(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.first()){
                produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getFloat("precoPorUnidade")
                );
            }else{
                throw new RuntimeException("Não existe um usuário com esse id");
            }
        }catch(SQLException | RuntimeException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro",0);
            
            return null;
        }
        
        return produto;
    }

    @Override
    public Integer update(Long id,Produto newProduto) {
        String sql = "UPDATE produtos SET nome=?,quantidade=?,precoPorUnidade=? WHERE id=?";
        
        try{
            PreparedStatement pstmt = DB.prepareStatement(sql);
            
            pstmt.setString(1, newProduto.getNome());
            pstmt.setInt(2, newProduto.getQuantidade());
            pstmt.setFloat(3,newProduto.getPrecoUnidade());
            pstmt.setLong(4, id);
            
            int r = pstmt.executeUpdate();
            
            return r;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
            
            return -1;
        }
    }

    @Override
    public Boolean delete(Long id) {
        String sql = "DELETE FROM produtos WHERE id=?";
        
        try{
            PreparedStatement pstmt = DB.prepareStatement(sql);
            
            pstmt.setLong(1, id);
            
            return pstmt.execute();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
            
            return false;
            
        }
    }
    
    
}
