package com.example.aula10.controller;
import com.example.aula10.dto.RespostaApi;
import com.example.aula10.model.Cliente;
import com.example.aula10.service.ClienteService;
import jakarta.validation.Valid;
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
    public ResponseEntity<RespostaApi> listarTodos() {
        List<Cliente> clientes = clienteService.listarTodos();
        RespostaApi resposta = new RespostaApi(true, "Clientes listados com sucesso", clientes);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaApi> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarPorId(id);
        if (cliente.isPresent()) {
            RespostaApi resposta = new RespostaApi(true, "Cliente encontrado", cliente.get());
            return ResponseEntity.ok(resposta);
        } else {
            RespostaApi resposta = new RespostaApi(false, "Cliente não encontrado");
            return ResponseEntity.badRequest().body(resposta);
        }
    }

    @PostMapping
    public ResponseEntity<RespostaApi> criar(@Valid @RequestBody Cliente cliente) {
        try {
            // Verificar se email já existe
            if (clienteService.existePorEmail(cliente.getEmail())) {
                RespostaApi resposta = new RespostaApi(false, "Cliente já cadastrado com este email");
                return ResponseEntity.badRequest().body(resposta);
            }

            Cliente clienteSalvo = clienteService.salvar(cliente);
            RespostaApi resposta = new RespostaApi(true, "Cliente cadastrado com sucesso", clienteSalvo);
            return ResponseEntity.ok(resposta);

        } catch (Exception e) {
            RespostaApi resposta = new RespostaApi(false, "Erro ao cadastrar cliente: " + e.getMessage());
            return ResponseEntity.badRequest().body(resposta);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespostaApi> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        try {
            if (!clienteService.buscarPorId(id).isPresent()) {
                RespostaApi resposta = new RespostaApi(false, "Cliente não encontrado");
                return ResponseEntity.badRequest().body(resposta);
            }

            cliente.setId(id);
            Cliente clienteAtualizado = clienteService.salvar(cliente);
            RespostaApi resposta = new RespostaApi(true, "Cliente atualizado com sucesso", clienteAtualizado);
            return ResponseEntity.ok(resposta);

        } catch (Exception e) {
            RespostaApi resposta = new RespostaApi(false, "Erro ao atualizar cliente: " + e.getMessage());
            return ResponseEntity.badRequest().body(resposta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaApi> deletar(@PathVariable Long id) {
        try {
            if (!clienteService.buscarPorId(id).isPresent()) {
                RespostaApi resposta = new RespostaApi(false, "Cliente não encontrado");
                return ResponseEntity.badRequest().body(resposta);
            }

            clienteService.deletar(id);
            RespostaApi resposta = new RespostaApi(true, "Cliente deletado com sucesso");
            return ResponseEntity.ok(resposta);

        } catch (Exception e) {
            RespostaApi resposta = new RespostaApi(false, "Erro ao deletar cliente: " + e.getMessage());
            return ResponseEntity.badRequest().body(resposta);
        }
    }
}

