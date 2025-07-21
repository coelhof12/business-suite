package com.example.stockmanagement.controller;

import com.example.stockmanagement.dto.ClientDTO;
import com.example.stockmanagement.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clients", description = "Endpoints for managing clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(summary = "Fetch all clients", description = "Retrieves a list of all clients in the system.")
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @Operation(summary = "Fetch a client by ID", description = "Retrieves details of a specific client.")
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @Operation(summary = "Add a new client", description = "Creates a new client record.")
    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.addClient(clientDTO));
    }

    @Operation(summary = "Update a client", description = "Updates the details of an existing client.")
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.updateClient(id, clientDTO));
    }

    @Operation(summary = "Delete a client", description = "Removes a client from the system.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}