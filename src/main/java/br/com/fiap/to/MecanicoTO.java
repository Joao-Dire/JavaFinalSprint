package br.com.fiap.to;

public class MecanicoTO {
    private int idMecanico;
    private String nome;
    private String telefone;
    private String email;
    private int oficinaIdOficina;

    // Getters e Setters

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOficinaIdOficina() {
        return oficinaIdOficina;
    }

    public void setOficinaIdOficina(int oficinaIdOficina) {
        this.oficinaIdOficina = oficinaIdOficina;
    }
}
