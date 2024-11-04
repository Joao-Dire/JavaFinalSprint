package br.com.fiap.bo;

import br.com.fiap.dao.MecanicoDAO;
import br.com.fiap.to.MecanicoTO;

import java.util.ArrayList;

public class MecanicoBO {
    private MecanicoDAO mecanicoDAO;

    public ArrayList<MecanicoTO> findAll() {
        mecanicoDAO = new MecanicoDAO();
        return mecanicoDAO.findAll();
    }

    public MecanicoTO findById(int idMecanico) {
        mecanicoDAO = new MecanicoDAO();
        return mecanicoDAO.findById(idMecanico);
    }

    public MecanicoTO save(MecanicoTO mecanico) {
        mecanicoDAO = new MecanicoDAO();
        validarMecanico(mecanico);
        return mecanicoDAO.save(mecanico);
    }

    public boolean delete(int idMecanico) {
        mecanicoDAO = new MecanicoDAO();
        return mecanicoDAO.delete(idMecanico);
    }

    public MecanicoTO update(MecanicoTO mecanico) {
        mecanicoDAO = new MecanicoDAO();
        validarMecanico(mecanico);
        return mecanicoDAO.update(mecanico);
    }

    private void validarMecanico(MecanicoTO mecanico) {
        if (mecanico.getNome() == null || mecanico.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do mecânico deve ser informado.");
        }
        if (mecanico.getTelefone() == null || mecanico.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("O telefone do mecânico deve ser informado.");
        }
        if (mecanico.getEmail() == null || mecanico.getEmail().isEmpty() || !mecanico.getEmail().contains("@")) {
            throw new IllegalArgumentException("O e-mail do mecânico deve ser válido.");
        }

    }
}
