/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author RaíssaArantes
 */
public class Conexao{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Informamos qual o Driver que está sendo utilizado
    private static final String URL = "jdbc:mysql://localhost:3306/pet?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "senha";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try{
            Class.forName(DRIVER); // Carrega e inicia o driver passado por parâmetro
            return DriverManager.getConnection(URL, USER, PASSWORD); // Estabelece a conexão
	}catch(ClassNotFoundException | SQLException ex){ // Tratamento de Exceções
            System.out.println(ex);
            return null;
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

