package com.example.stockmanagement.controller;

import com.example.stockmanagement.dto.AlertDTO;
import com.example.stockmanagement.service.AlertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts", description = "Endpoints for managing alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @Operation(summary = "Fetch all alerts", description = "Retrieves a list of all alerts in the system.")
    @GetMapping
    public ResponseEntity<List<AlertDTO>> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }

    @Operation(summary = "Create an alert", description = "Creates a new low stock alert for an inventory item.")
    @PostMapping("/create")
    public ResponseEntity<AlertDTO> createAlert(@Valid @RequestBody AlertDTO alertDTO) {
        AlertDTO createdAlert = alertService.createLowStockAlert(
                alertDTO.getInventoryItemId(),  // ✅ aqui era materialId
                alertDTO.getMessage()
        );
        return ResponseEntity.ok(createdAlert);
    }
}