package one.digitalinnovation.labprojectpatternsspring.controller;

import one.digitalinnovation.labprojectpatternsspring.model.Client;
import one.digitalinnovation.labprojectpatternsspring.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientRestController {
    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Client>> buscarTodos() {
        return ResponseEntity.ok(clientService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Client> inserir(@RequestBody Client client) {
        clientService.inserir(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> atualizar (@PathVariable Long id, @RequestBody Client client) {
        clientService.atualizar(id, client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clientService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
