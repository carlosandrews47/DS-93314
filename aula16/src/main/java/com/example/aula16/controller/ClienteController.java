package com.example.aula16.controller;

import com.example.aula16.model.Cliente;
import com.example.aula16.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        return cliente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente savedCliente = clienteService.save(cliente);
        return ResponseEntity.ok(savedCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);

        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Cliente existingCliente = clienteOptional.get();
        existingCliente.setNome(clienteDetails.getNome());
        existingCliente.setEmail(clienteDetails.getEmail());
        existingCliente.setTelefone(clienteDetails.getTelefone());
        existingCliente.setFormaPagamento(clienteDetails.getFormaPagamento());
        existingCliente.setEndereco(clienteDetails.getEndereco());

        Cliente updatedCliente = clienteService.save(existingCliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (clienteService.existsById(id)) {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
