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
        //O e-mail do cliente não pode ser vazio e deve ter formato válido
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty() || !cliente.getEmail().contains("@")) {
            throw new IllegalArgumentException("O e-mail do cliente deve ser válido.");
        }
        return clienteDAO.save(cliente);
    }

    public boolean delete(int idCliente) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.delete(idCliente);
    }

    public ClienteTO update(ClienteTO cliente) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.update(cliente);
    }
}
