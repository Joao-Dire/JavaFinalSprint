package br.com.fiap.to;

public class CarroTO {
        private int idCarro;
        private String placa;
        private String modelo;
        private int ano;
        private String cor;
        private int idCliente;

        public CarroTO() {
        }

        public CarroTO(int idCarro, String placa, String modelo, int ano, String cor, int idCliente) {
            this.idCarro = idCarro;
            this.placa = placa;
            this.modelo = modelo;
            this.ano = ano;
            this.cor = cor;
            this.idCliente = idCliente;
        }

        // Getters e Setters
        public int getIdCarro() {
            return idCarro;
        }

        public void setIdCarro(int idCarro) {
            this.idCarro = idCarro;
        }

        public String getPlaca() {
            return placa;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public String getCor() {
            return cor;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }

        public int getIdCliente() {
            return idCliente;
        }

        public void setIdCliente(int idCliente) {
            this.idCliente = idCliente;
        }

    }
