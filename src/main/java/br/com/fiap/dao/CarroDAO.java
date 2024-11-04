package br.com.fiap.dao;

import br.com.fiap.to.CarroTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO extends Repository {

    public ArrayList<CarroTO> findAll() {
        ArrayList<CarroTO> carros = new ArrayList<>();
        String sql = "SELECT * FROM T_CHL_VEICULO ORDER BY ID_VEICULO";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CarroTO carro = new CarroTO();
                carro.setIdCarro(rs.getInt("ID_VEICULO"));
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

    public CarroTO findById(int ID_VEICULO) {
        CarroTO carro = null;
        String sql = "SELECT * FROM T_CHL_VEICULO WHERE ID_VEICULO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, ID_VEICULO);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                carro = new CarroTO();
                carro.setIdCarro(rs.getInt("ID_VEICULO"));
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
        String sql = "INSERT INTO T_CHL_VEICULO(placa, modelo, ano, cor, CLIENTE_ID_CLIENTE) VALUES (?, ?, ?, ?, ?)";
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

    public boolean delete(int ID_VEICULO) {
        String sql = "DELETE FROM T_CHL_VEICULO WHERE ID_VEICULO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, ID_VEICULO);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public CarroTO update(CarroTO carro) {
        String sql = "UPDATE T_CHL_VEICULO SET placa = ?, modelo = ?, ano = ?, cor = ?, idCliente = ? WHERE ID_VEICULO = ?";
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
