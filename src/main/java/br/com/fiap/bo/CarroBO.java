package br.com.fiap.bo;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.to.CarroTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class CarroBO {
    private CarroDAO carroDAO;

    public ArrayList<CarroTO> findAll() {
        carroDAO = new CarroDAO();
        return carroDAO.findAll();
    }

    public CarroTO findById(int idCarro) {
        carroDAO = new CarroDAO();
        return carroDAO.findById(idCarro);
    }

    public CarroTO save(CarroTO carro) {
        carroDAO = new CarroDAO();
        //O ano do carro não pode ser maior que o ano atual
        if (carro.getAno() > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("O ano do carro não pode ser no futuro.");
        }
        return carroDAO.save(carro);
    }

    public boolean delete(int idCarro) {
        carroDAO = new CarroDAO();
        return carroDAO.delete(idCarro);
    }

    public CarroTO update(CarroTO carro) {
        carroDAO = new CarroDAO();
        return carroDAO.update(carro);
    }
}
