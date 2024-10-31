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

    public DiagnosticoTO save(DiagnosticoTO diagnostico) {
        diagnosticoDAO = new DiagnosticoDAO();
        //A data do diagnóstico não pode ser no futuro
        if (diagnostico.getDataHoraDiagnostico().toLocalDateTime().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data do diagnóstico não pode ser no futuro.");
        }
        return diagnosticoDAO.save(diagnostico);
    }

    public boolean delete(int idDiagnostico) {
        diagnosticoDAO = new DiagnosticoDAO();
        return diagnosticoDAO.delete(idDiagnostico);
    }

    public DiagnosticoTO update(DiagnosticoTO diagnostico) {
        diagnosticoDAO = new DiagnosticoDAO();
        return diagnosticoDAO.update(diagnostico);
    }
}
