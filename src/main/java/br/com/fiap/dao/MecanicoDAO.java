package br.com.fiap.dao;

import br.com.fiap.to.MecanicoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MecanicoDAO extends Repository {

    public ArrayList<MecanicoTO> findAll() {
        ArrayList<MecanicoTO> mecanicos = new ArrayList<>();
        String sql = "select * from ddd_mecanicos order by idMecanico";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MecanicoTO mecanico = new MecanicoTO();
                mecanico.setIdMecanico(rs.getInt("idMecanico"));
                mecanico.setNome(rs.getString("nome"));
                mecanico.setTelefone(rs.getString("telefone"));
                mecanico.setEmail(rs.getString("email"));
                mecanico.setOficinaIdOficina(rs.getInt("oficinaIdOficina"));
                mecanicos.add(mecanico);
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return mecanicos;
    }

    public MecanicoTO findById(int idMecanico) {
        MecanicoTO mecanico = null;
        String sql = "select * from ddd_mecanicos where idMecanico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idMecanico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mecanico = new MecanicoTO();
                mecanico.setIdMecanico(rs.getInt("idMecanico"));
                mecanico.setNome(rs.getString("nome"));
                mecanico.setTelefone(rs.getString("telefone"));
                mecanico.setEmail(rs.getString("email"));
                mecanico.setOficinaIdOficina(rs.getInt("oficinaIdOficina"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return mecanico;
    }

    public MecanicoTO save(MecanicoTO mecanico) {
        String sql = "insert into ddd_mecanicos(nome, telefone, email, oficinaIdOficina) values(?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, mecanico.getNome());
            ps.setString(2, mecanico.getTelefone());
            ps.setString(3, mecanico.getEmail());
            ps.setInt(4, mecanico.getOficinaIdOficina());
            if (ps.executeUpdate() > 0) {
                return mecanico;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(int idMecanico) {
        String sql = "delete from ddd_mecanicos where idMecanico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idMecanico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public MecanicoTO update(MecanicoTO mecanico) {
        String sql = "update ddd_mecanicos set nome=?, telefone=?, email=?, oficinaIdOficina=? where idMecanico=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, mecanico.getNome());
            ps.setString(2, mecanico.getTelefone());
            ps.setString(3, mecanico.getEmail());
            ps.setInt(4, mecanico.getOficinaIdOficina());
            ps.setInt(5, mecanico.getIdMecanico());
            if (ps.executeUpdate() > 0) {
                return mecanico;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
