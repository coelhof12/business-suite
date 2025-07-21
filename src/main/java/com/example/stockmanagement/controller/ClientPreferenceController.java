package com.example.stockmanagement.controller;

import com.example.stockmanagement.dto.ClientPreferenceDTO;
import com.example.stockmanagement.service.ClientPreferenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client-preferences")
@Tag(name = "Client Preferences", description = "Endpoints for managing client preferences")
public class ClientPreferenceController {

    private final ClientPreferenceService clientPreferenceService;

    public ClientPreferenceController(ClientPreferenceService clientPreferenceService) {
        this.clientPreferenceService = clientPreferenceService;
    }

    @Operation(summary = "Fetch client preferences", description = "Retrieves all preferences for a specific client.")
    @GetMapping("/{clientId}")
    public ResponseEntity<List<ClientPreferenceDTO>> getPreferencesByClientId(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientPreferenceService.getPreferencesByClientId(clientId));
    }

    @Operation(summary = "Add a client preference", description = "Creates a new preference for a client.")
    @PostMapping
    public ResponseEntity<ClientPreferenceDTO> addPreference(@Valid @RequestBody ClientPreferenceDTO clientPreferenceDTO) {
        return ResponseEntity.ok(clientPreferenceService.addPreference(clientPreferenceDTO));
    }

    @Operation(summary = "Update a client preference", description = "Updates the details of an existing client preference.")
    @PutMapping("/{preferenceId}")
    public ResponseEntity<ClientPreferenceDTO> updatePreference(@PathVariable Long preferenceId, @Valid @RequestBody ClientPreferenceDTO updatedPreferenceDTO) {
        return ResponseEntity.ok(clientPreferenceService.updatePreference(preferenceId, updatedPreferenceDTO));
    }

    @Operation(summary = "Delete a client preference", description = "Removes a client preference from the system.")
    @DeleteMapping("/{preferenceId}")
    public ResponseEntity<Void> deletePreference(@PathVariable Long preferenceId) {
        clientPreferenceService.deletePreference(preferenceId);
        return ResponseEntity.noContent().build();
    }
}