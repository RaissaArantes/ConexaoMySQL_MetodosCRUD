/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import DatabaseConnection.Conexao;
import Model.bean.Membros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author raiss
 */
public class MembrosDAO {
    public void Insert(Membros m) throws SQLException, ClassNotFoundException{ // O retorno é vazio, e recebe um objeto do tipo Membros
        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null; 
        try{
            stmt = con.prepareStatement("INSERT INTO membros VALUES (DEFAULT, ?)"); // Inserindo o comando SQL a ser usado
	    stmt.setString(1, m.getNome()); // O método setString, define que o valor passado será do tipo inteiro 
            stmt.executeUpdate(); 	// Método responsável por fazer a alteração no banco de dados (No caso, uma inserção)
        }catch(SQLException ex){     // Tratamento das exceções
            System.out.println(ex);
        } finally{			// Encerramento da conexão
            Conexao.closeConnection(con, stmt);
        }
    }
    public void Delete(Membros m) throws SQLException, ClassNotFoundException{ // O retorno é vazio, e recebe um objeto do tipo Membros
        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null; 
        try{
            stmt = con.prepareStatement("DELETE FROM membros WHERE id = ?"); // Inserindo o comando SQL a ser usado
	    stmt.setInt(1, m.getId());
            stmt.executeUpdate(); 	// Método responsável por fazer a alteração no banco de dados (No caso, remoção)
        }catch(SQLException ex){        // Tratamento das exceções
            System.out.println(ex);
        } 
    }
    public void Update(Membros m) throws SQLException, ClassNotFoundException{ // O retorno é vazio, e recebe um objeto do tipo Membros
        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null; 
        try{
            stmt = con.prepareStatement("UPDATE membros SET nome = ? WHERE id = ?"); // Inserindo o comando SQL a ser usado
	    stmt.setString(1, m.getNome());
            stmt.setInt(2, m.getId());
            stmt.executeUpdate(); 	// Método responsável por fazer a alteração no banco de dados (No caso, alteração)
        }catch(SQLException ex){        // Tratamento das exceções
            System.out.println(ex);
        }
    }
    public List<Membros> Select () throws SQLException, ClassNotFoundException{ // Retorno é uma lista de Membros
        Connection con = Conexao.getConnection(); // Busca uma conexão com o banco de dados
        PreparedStatement stmt = null;
        ResultSet rs = null; // Objeto que armazena o resultado de uma busca em uma estrutura de dados que pode ser percorrida
        List<Membros>membros = new ArrayList<>(); // Instancia uma nova lista para receber os valores do banco
        try{
            stmt = con.prepareStatement("SELECT * FROM membros");  // Inserindo o comando SQL a ser usado
            rs = stmt.executeQuery();  // Executa o comando SQL
            while(rs.next()){          // Loop responsável pela busca dos dados no banco que o repetirá até que não hajam valores
                Membros mem = new Membros();
                mem.setId(rs.getInt("id"));
                mem.setNome(rs.getString("nome"));
                membros.add(mem);   // Adiciona o objeto na lista
            }
        }catch(SQLException ex){    // Tratamento das exceções
            Logger.getLogger(MembrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return membros; // Retorna a lista
    }

}
