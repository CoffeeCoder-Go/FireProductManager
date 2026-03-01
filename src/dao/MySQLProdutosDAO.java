/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import configuration.DatabaseConnection;
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
 * @author Henrique Rigoni Nunes
 */
// Implementação para MySQL
public class MySQLProdutosDAO implements ProdutosDAO{
    public Connection DB;// Conexão


    // Criação
    // Cria um produto
    @Override
    public void create(Produto produto) throws SQLException{
        DB = DatabaseConnection.connect();
        // Comando sql para inserção
        String sql = "INSERT INTO produtos(nome,quantidade,precoPorUnidade) VALUES (?,?,?)";
        
        try(PreparedStatement pstm = DB.prepareStatement(sql)){// Prepara INSERÇÃO
            
            // (1,2,3) = (?,?,?)
            pstm.setString(1, produto.getNome());
            pstm.setInt(2, produto.getQuantidade());
            pstm.setFloat(3, produto.getPrecoUnidade());
            
            // Executa
            pstm.execute();
        }
        
        // Fecha conexão
        DatabaseConnection.closeConnection(DB);
    }

    // Listagem
    // Pega todos os produtos
    @Override
    public List<Produto> getAll() throws SQLException {
        DB = DatabaseConnection.connect();
        // Array de produtos
        List<Produto> produtos = new ArrayList<>();
        
        // Comando sql de Query
        String sql = "SELECT * FROM produtos";
        
        try(PreparedStatement ps = DB.prepareStatement(sql)){// Comando sql preparado
            
            // Executa a consulta
            ResultSet rs = ps.executeQuery(); // Conjunto de resultados
            
            // Se ainda houver próxima linha
            while(rs.next()){
                // Cria objeto Produto carregado
                Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getFloat("precoPorUnidade")
                );
                
                // Adiciona ao array
                produtos.add(produto);
            }
        }
        
        // Fecha conexão
        DatabaseConnection.closeConnection(DB);
        
        // Retorna todos os produtos
        return produtos;
    }

    // Procura
    // Procura um produto pelo nome
    @Override
    public List<Produto> searchByName(String name) throws SQLException{
        DB = DatabaseConnection.connect();
        List<Produto> produtos = new ArrayList<>();// Mesma coisa, lista de produtos
        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";// pega todos cujo nome comece com a expressão
        
        try(PreparedStatement pstmt = DB.prepareStatement(sql)){// Prepara a consulta
            
            // Gambiarra pra botar a expressão
            pstmt.setString(1, name+"%");
            
            // Executa a consulta
            ResultSet rs = pstmt.executeQuery(); // Conjunto de resultados
            
            // enquanto houver linhas
            while(rs.next()){
                // Cria objetos carregados
                Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getFloat("precoPorUnidade")
                );
                
                // Adiciona na lista
                produtos.add(produto);
            }
        }
        
        // Fecha conexão
        DatabaseConnection.closeConnection(DB);
        
        // Retorna a lista
        return produtos;
    }

    // Detalhes
    // Pega um único produto pelo id
    @Override
    public Produto getById(Long id) throws SQLException,RuntimeException{
        DB = DatabaseConnection.connect();
        Produto produto; // Declara um produto
        String sql = "SELECT * FROM produtos WHERE id=?";// Pega todos cujo id é igual o da entrada
        
        try(PreparedStatement pstmt = DB.prepareStatement(sql)){// Prepara consulta
            
            // 1=?
            pstmt.setLong(1, id);
            
            // Executa a consulta
            ResultSet rs = pstmt.executeQuery();// Conjunto de resultados
            
            // Move o cursor para o primeiro
            if(rs.first()){
                // Carrega um objeto
                produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getFloat("precoPorUnidade")
                );
            }else{
                // Manda exceção se não existir pelo menos 1
                throw new RuntimeException("Não existe um produto com esse id");
            }
            
            // Fecha conexão
            DatabaseConnection.closeConnection(DB);
            
            // Retorna produto
            return produto;
        }
        
        
    }

    // Atualização
    // Modifica um produto pelo nome e retorna o tanto de linhas modificadas
    @Override
    public void update(Long id,Produto newProduto) throws SQLException{
        DB = DatabaseConnection.connect();
        // Atualiza todos os campos cujo id é igual o da entrada
        String sql = "UPDATE produtos SET nome=?,quantidade=?,precoPorUnidade=? WHERE id=?";
        
        try(PreparedStatement pstmt = DB.prepareStatement(sql)){// Prepara a atualização
            
            // (nome=?,quantidade=?,precoPorUnidade=? WHERE id=?) = (1,2,3,4)
            pstmt.setString(1, newProduto.getNome());
            pstmt.setInt(2, newProduto.getQuantidade());
            pstmt.setFloat(3,newProduto.getPrecoUnidade());
            pstmt.setLong(4, id);
            
            // (Executa a atualização)
            pstmt.executeUpdate();
            
            // Fecha a conexão
            DatabaseConnection.closeConnection(DB);
            
        }
    }

    // Exclusão
    // Deleta um produto pelo id
    @Override
    public Boolean delete(Long id) throws SQLException{
        DB = DatabaseConnection.connect();
        String sql = "DELETE FROM produtos WHERE id=?";// Deleta um produto se o id for igual o da entrada
        
        try(PreparedStatement pstmt = DB.prepareStatement(sql)){// Prepara a exclusão
            
            // (id=?)=1
            pstmt.setLong(1, id);
            
            // Executa e guarda numa variável
            boolean result = pstmt.execute();
            
            // Fecha a conexão
            DatabaseConnection.closeConnection(DB);
            
            // Retorna o resultado
            return result;
        }
        
        
    }
    
    
}
