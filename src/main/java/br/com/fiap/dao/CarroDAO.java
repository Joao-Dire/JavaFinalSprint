package br.com.fiap.dao;

import br.com.fiap.to.CarroTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO extends Repository {

    public ArrayList<CarroTO> findAll() {
        ArrayList<CarroTO> carros = new ArrayList<>();
        String sql = "SELECT * FROM ddd_carros ORDER BY idCarro";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CarroTO carro = new CarroTO();
                carro.setIdCarro(rs.getInt("idCarro"));
                carro.setPlaca(rs.getString("placa"));
                carro.setModelo(rs.getString("modelo"));
                carro.setAno(rs.getInt("ano"));
                carro.setCor(rs.getString("cor"));
                carro.setIdCliente(rs.getInt("idCliente"));
                carros.add(carro);
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return carros.isEmpty() ? null : carros; // Retorna null se a lista estiver vazia
    }

    public CarroTO findById(int idCarro) {
        CarroTO carro = null;
        String sql = "SELECT * FROM ddd_carros WHERE idCarro = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idCarro);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                carro = new CarroTO();
                carro.setIdCarro(rs.getInt("idCarro"));
                carro.setPlaca(rs.getString("placa"));
                carro.setModelo(rs.getString("modelo"));
                carro.setAno(rs.getInt("ano"));
                carro.setCor(rs.getString("cor"));
                carro.setIdCliente(rs.getInt("idCliente"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return carro; // Retorna null se não encontrar
    }

    public CarroTO save(CarroTO carro) {
        String sql = "INSERT INTO ddd_carros(placa, modelo, ano, cor, idCliente) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getModelo());
            ps.setInt(3, carro.getAno());
            ps.setString(4, carro.getCor());
            ps.setInt(5, carro.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return carro;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null; // Retorna null em caso de falha
    }

    public boolean delete(int idCarro) {
        String sql = "DELETE FROM ddd_carros WHERE idCarro = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idCarro);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public CarroTO update(CarroTO carro) {
        String sql = "UPDATE ddd_carros SET placa = ?, modelo = ?, ano = ?, cor = ?, idCliente = ? WHERE idCarro = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getModelo());
            ps.setInt(3, carro.getAno());
            ps.setString(4, carro.getCor());
            ps.setInt(5, carro.getIdCliente());
            ps.setInt(6, carro.getIdCarro());
            if (ps.executeUpdate() > 0) {
                return carro; // Retorna o carro atualizado
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null; // Retorna null em caso de falha
    }
}
