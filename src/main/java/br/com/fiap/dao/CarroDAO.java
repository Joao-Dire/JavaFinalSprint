package br.com.fiap.dao;

import br.com.fiap.dao.Repository;
import br.com.fiap.to.CarroTO;

import java.sql.*;
import java.util.ArrayList;

public class CarroDAO extends Repository {
    public ArrayList<CarroTO> findAll() {
        ArrayList<CarroTO> carros = new ArrayList<>();
        String sql = "SELECT * FROM ddd_carros";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
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
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return carros;
    }
}
