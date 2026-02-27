/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;

import io.github.cdimascio.dotenv.Dotenv;// Biblioteca para acessar .env
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author cliente
 */
public class DatabaseConnection {
    // Carrega o dotenv
    private static Dotenv dotenv;
    
    // Pega pelo .env ou variável de ambiente
    public static String URL;// URL de conexão
    public static String USER;// Usuário do banco de dados, de preferência root
    public static String PASSWORD;// Senha do banco de dados
    
    static {
        dotenv = Dotenv.load();
        
        if(dotenv != null){
            // Verifica se existe URL e se ele é não nulo no .env
            if(!dotenv.get("URL").isEmpty() && dotenv.get("URL") != null){
                URL = dotenv.get("URL");
            }else{
                // Se não pega das variáveis de ambiente
                URL = System.getenv("URL");
            }

            // Verifica se existe USERNAME e se ele é não nulo no .env
            if(!dotenv.get("USERNAME").isEmpty() && dotenv.get("USERNAME") != null){
                USER = dotenv.get("USERNAME");
            }else{
                // Se não, pega das variáveis de ambiente
                USER = System.getenv("USERNAME");
            }

            // Verifica se existe PASSWORD e se ele é não nulo no .env
            if(!dotenv.get("PASSWORD").isEmpty() && dotenv.get("PASSWORD") != null){
                PASSWORD = dotenv.get("PASSWORD");
            }else{
                // Se não, pega das variáveis de ambiente
                PASSWORD = System.getenv("PASSWORD");
            }
        }else{
            URL = System.getenv("URL");
            USER = System.getenv("USERNAME");
            PASSWORD = System.getenv("PASSWORD");
        }
        
        
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
