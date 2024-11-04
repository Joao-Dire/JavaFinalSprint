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
        validarCarro(carro);
        return carroDAO.save(carro);
    }

    public boolean delete(int idCarro) {
        carroDAO = new CarroDAO();
        return carroDAO.delete(idCarro);
    }

    public CarroTO update(CarroTO carro) {
        carroDAO = new CarroDAO();
        validarCarro(carro);
        return carroDAO.update(carro);
    }

    private void validarCarro(CarroTO carro) {
        if (carro.getPlaca() == null || carro.getPlaca().isEmpty()) {
            throw new IllegalArgumentException("A placa do carro deve ser informada.");
        }
        if (carro.getPlaca().length() != 8) {
            throw new IllegalArgumentException("A placa do carro deve ter 8 caracteres.");
        }
        if (carro.getModelo() == null || carro.getModelo().isEmpty()) {
            throw new IllegalArgumentException("O modelo do carro deve ser informado.");
        }
        if (carro.getAno() > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("O ano do carro não pode ser no futuro.");
        }

    }
}
