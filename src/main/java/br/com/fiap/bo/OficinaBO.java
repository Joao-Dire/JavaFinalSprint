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
        validarOficina(oficina);
        return oficinaDAO.save(oficina);
    }

    public boolean delete(int idOficina) {
        oficinaDAO = new OficinaDAO();
        return oficinaDAO.delete(idOficina);
    }

    public OficinaTO update(OficinaTO oficina) {
        oficinaDAO = new OficinaDAO();
        validarOficina(oficina);
        return oficinaDAO.update(oficina);
    }

    private void validarOficina(OficinaTO oficina) {
        if (oficina.getNome() == null || oficina.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da oficina deve ser informado.");
        }
        if (oficina.getTelefone() == null || oficina.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("O telefone da oficina deve ser informado.");
        }
        if (oficina.getRua() == null || oficina.getRua().isEmpty()) {
            throw new IllegalArgumentException("A rua da oficina deve ser informada.");
        }
        if (oficina.getNumero() == null || oficina.getNumero().isEmpty()) {
            throw new IllegalArgumentException("O número da oficina deve ser informado.");
        }
        if (oficina.getBairro() == null || oficina.getBairro().isEmpty()) {
            throw new IllegalArgumentException("O bairro da oficina deve ser informado.");
        }
        if (oficina.getCidade() == null || oficina.getCidade().isEmpty()) {
            throw new IllegalArgumentException("A cidade da oficina deve ser informada.");
        }

    }
}
