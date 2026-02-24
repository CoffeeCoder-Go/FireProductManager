/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.helpers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author cliente
 */
public class FloatVerifier extends InputVerifier{

    @Override
    public boolean verify(JComponent jc) {
        try{
            String text = ((JTextField) jc).getText();
        
            if(text.isEmpty()){
                return true;
            }
            
            if(text.contains(".")){
                String[] parts = text.split("\\.");

                if(parts[1].length() == 2 && parts[0].length() >= 1){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage(), "Erro", 0);
            return false;
        }
        
        
    }
    
}
