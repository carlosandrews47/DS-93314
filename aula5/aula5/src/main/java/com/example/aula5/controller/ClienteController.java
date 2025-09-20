package com.example.aula5.controller;

import com.example.aula5.model.Cliente;
import com.example.aula5.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // GET - Listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        try {
            List<Cliente> clientes = clienteService.findAll();
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET - Buscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable UUID id) {
        try {
            Optional<Cliente> cliente = clienteService.findById(id);
            return cliente.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // POST - Criar novo cliente
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        try {
            // Validar dados do cliente
            if (!clienteService.validarCliente(cliente)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            Optional<Cliente> novoCliente = clienteService.criarCliente(cliente);

            return novoCliente.map(clienteSalvo ->
                    ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo)
            ).orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PUT - Atualizar cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable UUID id, @RequestBody Cliente clienteAtualizado) {
        try {
            // Validar dados do cliente
            if (!clienteService.validarCliente(clienteAtualizado)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            Optional<Cliente> clienteAtualizadoSalvo = clienteService.atualizarCliente(id, clienteAtualizado);

            return clienteAtualizadoSalvo.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // DELETE - Remover cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try {
            if (clienteService.existsById(id)) {
                clienteService.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET - Buscar cliente por telefone
    @GetMapping("/telefone/{telefone}")
    public ResponseEntity<Cliente> getByTelefone(@PathVariable String telefone) {
        try {
            Optional<Cliente> cliente = clienteService.findByTelefone(telefone);
            return cliente.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET - Buscar clientes por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Cliente>> getByNome(@PathVariable String nome) {
        try {
            List<Cliente> clientes = clienteService.findByNome(nome);
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET - Verificar se telefone existe
    @GetMapping("/telefone/{telefone}/existe")
    public ResponseEntity<Boolean> telefoneExiste(@PathVariable String telefone) {
        try {
            boolean existe = clienteService.existsByTelefone(telefone);
            return ResponseEntity.ok(existe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET - Contar total de clientes
    @GetMapping("/count")
    public ResponseEntity<Long> countClientes() {
        try {
            long total = clienteService.count();
            return ResponseEntity.ok(total);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}