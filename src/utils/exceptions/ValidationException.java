/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.exceptions;

/**
 *
 * @author cliente
 */
public class ValidationException extends RuntimeException{
    public ValidationException(String msg){
        super(msg);
    }
}
