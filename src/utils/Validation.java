/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entity.Produto;
import utils.exceptions.ValidationException;

/**
 *
 * @author cliente
 */
public class Validation {
    public static boolean valid(Produto produto) throws ValidationException{
        if(produto.getQuantidade() < 0 || produto.getPrecoUnidade() < 0.0){
            throw new ValidationException("O preço ou a quantidade não pode ser menor que 0!");
        }
        
        String original = Character.valueOf(produto.getNome().charAt(0)).toString();
        String capitalized = original.toUpperCase();
        
        if(!original.equals(capitalized)){
            throw new ValidationException("A primeira letra deve ser maiúscula");
        }
        
        return true;
    } 
}
