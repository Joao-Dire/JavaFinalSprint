package br.com.fiap.dao;

import br.com.fiap.to.OficinaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaDAO extends Repository {

    public ArrayList<OficinaTO> findAll() {
        ArrayList<OficinaTO> oficinas = new ArrayList<>();
        String sql = "select * from ddd_oficinas order by idOficina";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OficinaTO oficina = new OficinaTO();
                oficina.setIdOficina(rs.getInt("idOficina"));
                oficina.setNome(rs.getString("nome"));
                oficina.setTelefone(rs.getString("telefone"));
                oficina.setRua(rs.getString("rua"));
                oficina.setNumero(rs.getString("numero"));
                oficina.setBairro(rs.getString("bairro"));
                oficina.setCidade(rs.getString("cidade"));
                oficinas.add(oficina);
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return oficinas;
    }

    public OficinaTO findById(int idOficina) {
        OficinaTO oficina = null;
        String sql = "select * from ddd_oficinas where idOficina = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idOficina);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                oficina = new OficinaTO();
                oficina.setIdOficina(rs.getInt("idOficina"));
                oficina.setNome(rs.getString("nome"));
                oficina.setTelefone(rs.getString("telefone"));
                oficina.setRua(rs.getString("rua"));
                oficina.setNumero(rs.getString("numero"));
                oficina.setBairro(rs.getString("bairro"));
                oficina.setCidade(rs.getString("cidade"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return oficina;
    }

    public OficinaTO save(OficinaTO oficina) {
        String sql = "insert into ddd_oficinas(nome, telefone, rua, numero, bairro, cidade) values(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, oficina.getNome());
            ps.setString(2, oficina.getTelefone());
            ps.setString(3, oficina.getRua());
            ps.setString(4, oficina.getNumero());
            ps.setString(5, oficina.getBairro());
            ps.setString(6, oficina.getCidade());
            if (ps.executeUpdate() > 0) {
                return oficina;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(int idOficina) {
        String sql = "delete from ddd_oficinas where idOficina = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idOficina);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public OficinaTO update(OficinaTO oficina) {
        String sql = "update ddd_oficinas set nome=?, telefone=?, rua=?, numero=?, bairro=?, cidade=? where idOficina=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, oficina.getNome());
            ps.setString(2, oficina.getTelefone());
            ps.setString(3, oficina.getRua());
            ps.setString(4, oficina.getNumero());
            ps.setString(5, oficina.getBairro());
            ps.setString(6, oficina.getCidade());
            ps.setInt(7, oficina.getIdOficina());
            if (ps.executeUpdate() > 0) {
                return oficina;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
