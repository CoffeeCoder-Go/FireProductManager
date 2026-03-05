/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author cliente
 */
public class DatabaseConnection {
    
    // Pega pelo .env ou variável de ambiente
    public static String URL;// URL de conexão
    public static String USER;// Usuário do banco de dados, de preferência root
    public static String PASSWORD;// Senha do banco de dados
    
    static {
        Properties properties = new Properties();
        
        try (InputStream file = DatabaseConnection.class.getClassLoader().getResourceAsStream("properties/main.properties")) {

            properties.load(file);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Config File", JOptionPane.ERROR_MESSAGE);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Config File", JOptionPane.ERROR_MESSAGE);
        }
        
        Dotenv dotenv = Dotenv.load();
        
        URL = properties.getProperty("database.info.url", dotenv.get("URL"));
        USER = properties.getProperty("database.info.user",dotenv.get("USER"));
        PASSWORD=properties.getProperty("database.info.password",dotenv.get("PASSWORD"));
    }
    
    // Conecta e retorna a conexão
    public static Connection connect(){
        try{
            // Analisa se existe o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Tenta pegar a conexão
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Mensagem de sucesso
            System.out.println("Sucesso!");
            
            // Retorna a conexão
            return connection;
        }catch(SQLException | ClassNotFoundException e){// Se não tiver o driver ou erro de conexão e sql
            // Mostra mensagem de conexão falha
            JOptionPane.showMessageDialog(null,e.getMessage(), "Connection", JOptionPane.ERROR_MESSAGE);
            
            // Retorna nulo
            return null;
        }
    }
    
    // Fecha a conexão
    public static void closeConnection(Connection con){
        try{ con.close(); } catch(SQLException e){ JOptionPane.showMessageDialog(null,e.getMessage(), "Connection", JOptionPane.ERROR_MESSAGE); }
    }
    
    
}
