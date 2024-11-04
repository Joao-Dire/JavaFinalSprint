package br.com.fiap.bo;

import br.com.fiap.dao.DiagnosticoDAO;
import br.com.fiap.to.DiagnosticoTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DiagnosticoBO {
    private DiagnosticoDAO diagnosticoDAO;

    public ArrayList<DiagnosticoTO> findAll() {
        diagnosticoDAO = new DiagnosticoDAO();
        return diagnosticoDAO.findAll();
    }

    public DiagnosticoTO findById(int idDiagnostico) {
        diagnosticoDAO = new DiagnosticoDAO();
        return diagnosticoDAO.findById(idDiagnostico);
    }

    public ArrayList<DiagnosticoTO> findByVeiculoId(int veiculoId) {
        return diagnosticoDAO.findByVeiculoId(veiculoId);
    }


    public DiagnosticoTO save(DiagnosticoTO diagnostico) {
        diagnosticoDAO = new DiagnosticoDAO();
        validarDiagnostico(diagnostico);
        return diagnosticoDAO.save(diagnostico);
    }

    public boolean delete(int idDiagnostico) {
        diagnosticoDAO = new DiagnosticoDAO();
        return diagnosticoDAO.delete(idDiagnostico);
    }

    public DiagnosticoTO update(DiagnosticoTO diagnostico) {
        diagnosticoDAO = new DiagnosticoDAO();
        validarDiagnostico(diagnostico);
        return diagnosticoDAO.update(diagnostico);
    }

    private void validarDiagnostico(DiagnosticoTO diagnostico) {
        if (diagnostico.getDataHoraDiagnostico().toLocalDateTime().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data do diagnóstico não pode ser no futuro.");
        }
        if (diagnostico.getResultado() == null || diagnostico.getResultado().isEmpty()) {
            throw new IllegalArgumentException("O resultado do diagnóstico deve ser informado.");
        }

    }
}
