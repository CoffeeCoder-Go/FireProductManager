/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Produto;
import java.util.List;

/**
 *
 * @author cliente
 */
public interface ProdutosDAO {
    public void create(Produto produto);
    public List<Produto> getAll();
    public List<Produto> searchByName(String nome);
    public Produto getById(Long id);
    public Integer update(Long id,Produto newProduto);
    public Boolean delete(Long id);
}
