/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Produto;
import java.util.List;

/**
 *
 * @author Henrique Rigoni Nunes
 */
// Interface padrão de implementação das ações de armazenamento
public interface ProdutosDAO {
    public void create(Produto produto);// Registra um produto
    public List<Produto> getAll();// Pega todos os produtos
    public List<Produto> searchByName(String nome);// Procura produto pelo nome
    public Produto getById(Long id);// Pega um produto especifico pelo id
    public Integer update(Long id,Produto newProduto);// Modifica um produto e retorna o tanto de linhas que foram modificadas
    public Boolean delete(Long id);// Deleta um produto e retorna um booleano
}
