package br.com.fiap.dao;

import br.com.fiap.to.DiagnosticoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class DiagnosticoDAO extends Repository {

    public ArrayList<DiagnosticoTO> findAll() {
        ArrayList<DiagnosticoTO> diagnosticos = new ArrayList<>();
        String sql = "select * from ddd_diagnosticos order by idDiagnostico";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DiagnosticoTO diagnostico = new DiagnosticoTO();
                diagnostico.setIdDiagnostico(rs.getInt("idDiagnostico"));
                diagnostico.setDataHoraDiagnostico(new java.sql.Timestamp(rs.getTimestamp("dataHoraDiagnostico").getTime()));
                diagnostico.setResultado(rs.getString("resultado"));
                diagnostico.setDetalhes(rs.getString("detalhes"));
                diagnostico.setVeiculoIdVeiculo(rs.getInt("veiculoIdVeiculo"));
                diagnosticos.add(diagnostico);
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return diagnosticos;
    }

    public DiagnosticoTO findById(int idDiagnostico) {
        DiagnosticoTO diagnostico = null;
        String sql = "select * from ddd_diagnosticos where idDiagnostico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idDiagnostico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                diagnostico = new DiagnosticoTO();
                diagnostico.setIdDiagnostico(rs.getInt("idDiagnostico"));
                diagnostico.setDataHoraDiagnostico(new java.sql.Timestamp(rs.getTimestamp("dataHoraDiagnostico").getTime()));
                diagnostico.setResultado(rs.getString("resultado"));
                diagnostico.setDetalhes(rs.getString("detalhes"));
                diagnostico.setVeiculoIdVeiculo(rs.getInt("veiculoIdVeiculo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return diagnostico;
    }

    public DiagnosticoTO save(DiagnosticoTO diagnostico) {
        String sql = "insert into ddd_diagnosticos(dataHoraDiagnostico, resultado, detalhes, veiculoIdVeiculo) values(?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setTimestamp(1, new java.sql.Timestamp(diagnostico.getDataHoraDiagnostico().getTime()));
            ps.setString(2, diagnostico.getResultado());
            ps.setString(3, diagnostico.getDetalhes());
            ps.setInt(4, diagnostico.getVeiculoIdVeiculo());
            if (ps.executeUpdate() > 0) {
                return diagnostico;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(int idDiagnostico) {
        String sql = "delete from ddd_diagnosticos where idDiagnostico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idDiagnostico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public DiagnosticoTO update(DiagnosticoTO diagnostico) {
        String sql = "update ddd_diagnosticos set dataHoraDiagnostico=?, resultado=?, detalhes=?, veiculoIdVeiculo=? where idDiagnostico=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setTimestamp(1, new java.sql.Timestamp(diagnostico.getDataHoraDiagnostico().getTime()));
            ps.setString(2, diagnostico.getResultado());
            ps.setString(3, diagnostico.getDetalhes());
            ps.setInt(4, diagnostico.getVeiculoIdVeiculo());
            ps.setInt(5, diagnostico.getIdDiagnostico());
            if (ps.executeUpdate() > 0) {
                return diagnostico;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}