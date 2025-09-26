package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(UUID id) {
        return clienteRepository.findById(id);
    }

    public Cliente salvar(Cliente cliente) {
        if (clienteRepository.existsByProtocoloAtendimento(cliente.getProtocoloAtendimento())) {
            throw new RuntimeException("Já existe um cliente com este protocolo de atendimento");
        }
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(UUID id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    if (!cliente.getProtocoloAtendimento().equals(clienteAtualizado.getProtocoloAtendimento()) &&
                            clienteRepository.existsByProtocoloAtendimento(clienteAtualizado.getProtocoloAtendimento())) {
                        throw new RuntimeException("Já existe outro cliente com este protocolo de atendimento");
                    }

                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
                    cliente.setProtocoloAtendimento(clienteAtualizado.getProtocoloAtendimento());

                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
    }

    public void deletar(UUID id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com ID: " + id);
        }
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> buscarPorProtocolo(String protocolo) {
        return clienteRepository.findByProtocoloAtendimento(protocolo);
    }
}