/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Produto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Henrique Rigoni Nunes
 */
// Interface padrão de implementação das ações de armazenamento
public interface ProdutosDAO {
    public void create(Produto produto) throws SQLException;// Registra um produto
    public List<Produto> getAll() throws SQLException;// Pega todos os produtos
    public List<Produto> searchByName(String nome) throws SQLException;// Procura produto pelo nome
    public Produto getById(Long id) throws SQLException,RuntimeException;// Pega um produto especifico pelo id
    public void update(Long id,Produto newProduto) throws SQLException;// Modifica um produto e retorna o tanto de linhas que foram modificadas
    public Boolean delete(Long id) throws SQLException;// Deleta um produto e retorna um booleano
}
