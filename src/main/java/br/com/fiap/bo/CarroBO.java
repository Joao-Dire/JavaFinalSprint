package br.com.fiap.bo;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.to.CarroTO;

import java.util.ArrayList;


public class CarroBO {
    private CarroDAO carroDAO;

    public ArrayList<CarroTO> findall() {
        carroDAO = new CarroDAO();

        return carroDAO.findAll();
    }
}
