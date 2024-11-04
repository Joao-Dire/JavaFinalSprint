package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.to.ClienteTO;

import java.util.ArrayList;

public class ClienteBO {
    private ClienteDAO clienteDAO;

    public ArrayList<ClienteTO> findAll() {
        clienteDAO = new ClienteDAO();
        return clienteDAO.findAll();
    }

    public ClienteTO findById(int idCliente) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.findById(idCliente);
    }

    public ClienteTO save(ClienteTO cliente) {
        clienteDAO = new ClienteDAO();
        validarCliente(cliente);
        return clienteDAO.save(cliente);
    }

    public boolean delete(int idCliente) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.delete(idCliente);
    }

    public ClienteTO update(ClienteTO cliente) {
        clienteDAO = new ClienteDAO();
        validarCliente(cliente);
        return clienteDAO.update(cliente);
    }

    private void validarCliente(ClienteTO cliente) {
        if (cliente.getNomeCliente() == null || cliente.getNomeCliente().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente deve ser informado.");
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("O telefone do cliente deve ser informado.");
        }
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty() || !cliente.getEmail().contains("@")) {
            throw new IllegalArgumentException("O e-mail do cliente deve ser válido.");
        }

    }

}
