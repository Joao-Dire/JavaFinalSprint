package br.com.fiap.dao;

import br.com.fiap.to.CarroTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CarroDAO {

    public ArrayList<CarroTO> findall() {
        ArrayList<CarroTO> carros = new ArrayList<CarroTO>();
        CarroTO carro = new CarroTO(1, "ABC-1234", "Modelo X", 2020, "Preto", 1);
        carros.add(carro);

        carro = new CarroTO(2, "DEF-5678", "Modelo Y", 2021, "Branco", 2);
        carros.add(carro);
        return carros;
    }

}
