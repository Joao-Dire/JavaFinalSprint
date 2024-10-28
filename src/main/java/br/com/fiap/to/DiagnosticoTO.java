package br.com.fiap.to;

import java.security.Timestamp;

public class DiagnosticoTO {
    private int idDiagnostico;
    private Timestamp dataHoraDiagnostico;
    private String resultado;
    private String detalhes;
    private int veiculoIdVeiculo;

    // Getters e Setters

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Timestamp getDataHoraDiagnostico() {
        return dataHoraDiagnostico;
    }

    public void setDataHoraDiagnostico(Timestamp dataHoraDiagnostico) {
        this.dataHoraDiagnostico = dataHoraDiagnostico;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public int getVeiculoIdVeiculo() {
        return veiculoIdVeiculo;
    }

    public void setVeiculoIdVeiculo(int veiculoIdVeiculo) {
        this.veiculoIdVeiculo = veiculoIdVeiculo;
    }

}
