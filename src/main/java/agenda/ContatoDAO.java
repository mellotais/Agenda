package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.time.LocalDate;

public class ContatoDAO {
    final String NOMEDATABELA = "contato";

    public boolean inserir(Contato contato) {
        try (Connection conn = Conexao.conectar()) {
            String sql = "INSERT INTO " + NOMEDATABELA + " (codigo, nome, dataNascimento, telefone, email) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, contato.getCodigo());
                ps.setString(2, contato.getNome());
                ps.setString(3, contato.getDataNascimento().toString());
                ps.setString(4, contato.getTelefone());
                ps.setString(5, contato.getEmail());
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean alterar(Contato contato) {
        try (Connection conn = Conexao.conectar()){
            String sql = "UPDATE " + NOMEDATABELA +  " SET codigo = ?, nome = ?, dataNascimento = ?, telefone = ?,  email = ?  WHERE codigo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, contato.getCodigo());
            ps.setString(2, contato.getNome());
            ps.setString(3, contato.getDataNascimento().toString());
            ps.setString(4, contato.getTelefone());
            ps.setString(5, contato.getEmail());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public boolean excluir(Contato contato) {
        try (Connection conn = Conexao.conectar()){
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE (codigo, nome, dataNascimento, telefone, email) = ( ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, contato.getCodigo());
            ps.setString(2, contato.getNome());
            ps.setString(3, contato.getDataNascimento().toString());
            ps.setString(4, contato.getTelefone());
            ps.setString(5, contato.getEmail());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
  
    public boolean existe(Contato contato) {
        try (Connection conn = Conexao.conectar()){
            String sql = "SELECT * FROM " + NOMEDATABELA + "  WHERE  (codigo, nome, dataNascimento, telefone, email) = ( ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, contato.getCodigo());
            ps.setString(2, contato.getNome());
            ps.setString(3, contato.getDataNascimento().toString());
            ps.setString(4, contato.getTelefone());
            ps.setString(5, contato.getEmail());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            //System.err.println("Erro: " + e.toString());
            //e.printStackTrace();
            return false;
        }
        return false;
    } 
  
    public List<Contato> pesquisarTodos() {
        try (Connection conn = Conexao.conectar()){
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Contato> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            //System.err.println("Erro: " + e.toString());
            //e.printStackTrace();
            return null;
        }
    }
    public List<Contato> montarLista(ResultSet rs) {
        List<Contato> listObj = new ArrayList<Contato>();
        try {
            while (rs.next()) {
            	int codigo = rs.getInt(1);
                String nome = rs.getString(2);
                LocalDate dataNascimento = LocalDate.parse(rs.getString(3));
                String telefone = rs.getString(4);
                String email = rs.getString(5);
                
                Contato obj = new Contato(codigo, nome, dataNascimento, telefone, email);
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Contato> procurarPorNome(String nome) {
        try (Connection conn = Conexao.conectar()){
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%"); // Procura por parte do nome
            ResultSet rs = ps.executeQuery();
            List<Contato> listObj = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}