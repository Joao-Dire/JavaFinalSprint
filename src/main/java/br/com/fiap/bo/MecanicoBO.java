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
        //O telefone do mecânico não pode ser vazio
        if (mecanico.getTelefone() == null || mecanico.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("O telefone do mecânico deve ser informado.");
        }
        return mecanicoDAO.save(mecanico);
    }

    public boolean delete(int idMecanico) {
        mecanicoDAO = new MecanicoDAO();
        return mecanicoDAO.delete(idMecanico);
    }

    public MecanicoTO update(MecanicoTO mecanico) {
        mecanicoDAO = new MecanicoDAO();
        return mecanicoDAO.update(mecanico);
    }
}
