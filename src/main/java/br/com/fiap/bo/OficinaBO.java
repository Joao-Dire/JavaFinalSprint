package br.com.fiap.bo;

import br.com.fiap.dao.OficinaDAO;
import br.com.fiap.to.OficinaTO;

import java.util.ArrayList;

public class OficinaBO {
    private OficinaDAO oficinaDAO;

    public ArrayList<OficinaTO> findAll() {
        oficinaDAO = new OficinaDAO();
        return oficinaDAO.findAll();
    }

    public OficinaTO findById(int idOficina) {
        oficinaDAO = new OficinaDAO();
        return oficinaDAO.findById(idOficina);
    }

    public OficinaTO save(OficinaTO oficina) {
        oficinaDAO = new OficinaDAO();
        //O nome da oficina não pode ser vazio
        if (oficina.getNome() == null || oficina.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da oficina deve ser informado.");
        }
        return oficinaDAO.save(oficina);
    }

    public boolean delete(int idOficina) {
        oficinaDAO = new OficinaDAO();
        return oficinaDAO.delete(idOficina);
    }

    public OficinaTO update(OficinaTO oficina) {
        oficinaDAO = new OficinaDAO();
        return oficinaDAO.update(oficina);
    }
}
