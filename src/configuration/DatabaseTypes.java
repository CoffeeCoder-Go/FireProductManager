/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package configuration;

import dao.MySQLProdutosDAO;
import dao.ProdutosDAO;

/**
 *
 * @author cliente
 */
public enum DatabaseTypes {
    MYSQL(new MySQLProdutosDAO());
    
    private ProdutosDAO dao;
    
    private DatabaseTypes(ProdutosDAO dao){
        this.dao = dao;
    }
    
    public ProdutosDAO get(){
        return this.dao;
    }
}
