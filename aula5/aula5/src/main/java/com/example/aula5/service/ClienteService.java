package com.example.aula5.service;

import com.example.aula5.model.Cliente;
import com.example.aula5.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Buscar todos os clientes
     */
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    /**
     * Buscar cliente por ID
     */
    public Optional<Cliente> findById(UUID id) {
        return clienteRepository.findById(id);
    }

    /**
     * Salvar/atualizar cliente
     */
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Deletar cliente por ID
     */
    public void deleteById(UUID id) {
        clienteRepository.deleteById(id);
    }

    /**
     * Verificar se cliente existe por ID
     */
    public boolean existsById(UUID id) {
        return clienteRepository.existsById(id);
    }

    /**
     * Buscar cliente por telefone
     */
    public Optional<Cliente> findByTelefone(String telefone) {
        return clienteRepository.findByTelefone(telefone);
    }

    /**
     * Verificar se telefone já existe
     */
    public boolean existsByTelefone(String telefone) {
        return clienteRepository.existsByTelefone(telefone);
    }

    /**
     * Verificar se telefone pertence a outro cliente
     */
    public boolean telefonePertenceAOutroCliente(String telefone, UUID idClienteAtual) {
        Optional<Cliente> clienteComTelefone = clienteRepository.findByTelefone(telefone);
        return clienteComTelefone.isPresent() && !clienteComTelefone.get().getId().equals(idClienteAtual);
    }

    /**
     * Buscar clientes por nome
     */
    public List<Cliente> findByNome(String nome) {
        return clienteRepository.buscarPorParteDoNome(nome);
    }

    /**
     * Buscar cliente por nome exato
     */
    public Optional<Cliente> findByNomeExato(String nome) {
        return clienteRepository.findByNome(nome);
    }

    /**
     * Contar total de clientes
     */
    public long count() {
        return clienteRepository.count();
    }

    /**
     * Criar cliente com validação
     */
    public Optional<Cliente> criarCliente(Cliente cliente) {
        if (clienteRepository.existsByTelefone(cliente.getTelefone())) {
            return Optional.empty(); // Telefone já existe
        }

        Cliente clienteSalvo = clienteRepository.save(cliente);
        return Optional.of(clienteSalvo);
    }

    /**
     * Atualizar cliente com validação
     */
    public Optional<Cliente> atualizarCliente(UUID id, Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();

            // Verificar se o telefone já pertence a outro cliente
            if (telefonePertenceAOutroCliente(clienteAtualizado.getTelefone(), id)) {
                return Optional.empty(); // Telefone já pertence a outro cliente
            }

            cliente.setNome(clienteAtualizado.getNome());
            cliente.setTelefone(clienteAtualizado.getTelefone());

            Cliente clienteAtualizadoSalvo = clienteRepository.save(cliente);
            return Optional.of(clienteAtualizadoSalvo);
        }

        return Optional.empty(); // Cliente não encontrado
    }

    /**
     * Buscar clientes ativos (exemplo de método com lógica de negócio)
     */
    public List<Cliente> findClientesAtivos() {
        // Este é um exemplo - você pode adicionar lógica de negócio aqui
        return clienteRepository.findAll();
    }

    /**
     * Validar dados do cliente
     */
    public boolean validarCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            return false;
        }

        if (cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()) {
            return false;
        }

        // Validar formato do telefone (exemplo simples)
        return cliente.getTelefone().matches("^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$");
    }
}
