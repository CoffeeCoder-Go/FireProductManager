/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author cliente
 */
public class DatabaseConnection {
    private static Dotenv dotenv = Dotenv.load();
    public static String URL =  dotenv.get("URL");
    public static String USER = dotenv.get("USERNAME");
    public static String PASSWORD = dotenv.get("PASSWORD");
    
    public static Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            JOptionPane.showMessageDialog(null, "Successfully Conected!","Success",JOptionPane.INFORMATION_MESSAGE);
            
            return connection;
        }catch(SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e.getMessage(), "Connection", JOptionPane.ERROR_MESSAGE);
            
            return null;
        }
    }
    
}
