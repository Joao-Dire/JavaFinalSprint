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
        String sql = "select * from T_CHL_DIAGNOSTICO order by ID_DIAGNOSTICO";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DiagnosticoTO diagnostico = new DiagnosticoTO();
                diagnostico.setIdDiagnostico(rs.getInt("ID_DIAGNOSTICO"));
                diagnostico.setDataHoraDiagnostico(new java.sql.Timestamp(rs.getTimestamp("DATA_HORA_DIAGNOSTICO").getTime()));
                diagnostico.setResultado(rs.getString("RESULTADO"));
                diagnostico.setDetalhes(rs.getString("DETALHES"));
                diagnostico.setVeiculoIdVeiculo(rs.getInt("VEICULO_ID_VEICULO"));
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
        String sql = "select * from T_CHL_DIAGNOSTICO where ID_DIAGNOSTICO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idDiagnostico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                diagnostico = new DiagnosticoTO();
                diagnostico.setIdDiagnostico(rs.getInt("ID_DIAGNOSTICO"));
                diagnostico.setDataHoraDiagnostico(new java.sql.Timestamp(rs.getTimestamp("DATA_HORA_DIAGNOSTICO").getTime()));
                diagnostico.setResultado(rs.getString("RESULTADO"));
                diagnostico.setDetalhes(rs.getString("DETALHES"));
                diagnostico.setVeiculoIdVeiculo(rs.getInt("VEICULO_ID_VEICULO"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return diagnostico;
    }

    public ArrayList<DiagnosticoTO> findByVeiculoId(int veiculoId) {
        ArrayList<DiagnosticoTO> diagnosticos = new ArrayList<>();
        String sql = "SELECT * FROM T_CHL_DIAGNOSTICO WHERE VEICULO_ID_VEICULO = ? ORDER BY DATA_HORA_DIAGNOSTICO";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, veiculoId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DiagnosticoTO diagnostico = new DiagnosticoTO();
                diagnostico.setIdDiagnostico(rs.getInt("ID_DIAGNOSTICO"));
                diagnostico.setDataHoraDiagnostico(new java.sql.Timestamp(rs.getTimestamp("DATA_HORA_DIAGNOSTICO").getTime()));
                diagnostico.setResultado(rs.getString("RESULTADO"));
                diagnostico.setDetalhes(rs.getString("DETALHES"));
                diagnostico.setVeiculoIdVeiculo(rs.getInt("VEICULO_ID_VEICULO"));
                diagnosticos.add(diagnostico);
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return diagnosticos;
    }

    public DiagnosticoTO save(DiagnosticoTO diagnostico) {
        String sql = "insert into T_CHL_DIAGNOSTICO(ID_DIAGNOSTICO, DATA_HORA_DIAGNOSTICO, RESULTADO, DETALHES, VEICULO_ID_VEICULO) values(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, diagnostico.getIdDiagnostico());
            ps.setTimestamp(2, new java.sql.Timestamp(diagnostico.getDataHoraDiagnostico().getTime()));
            ps.setString(3, diagnostico.getResultado());
            ps.setString(4, diagnostico.getDetalhes());
            ps.setInt(5, diagnostico.getVeiculoIdVeiculo());
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
        String sql = "delete from T_CHL_DIAGNOSTICO where ID_DIAGNOSTICO = ?";
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
        String sql = "update T_CHL_DIAGNOSTICO set DATA_HORA_DIAGNOSTICO=?, RESULTADO=?, DETALHES=?, VEICULO_ID_VEICULO=? where ID_DIAGNOSTICO=?";
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