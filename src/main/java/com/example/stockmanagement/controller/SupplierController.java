package com.example.stockmanagement.controller;

import com.example.stockmanagement.dto.SupplierDTO;
import com.example.stockmanagement.service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "Suppliers", description = "Endpoints for managing suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Operation(summary = "Fetch all suppliers", description = "Retrieves a list of all suppliers.")
    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @Operation(summary = "Fetch a supplier by ID", description = "Retrieves details of a specific supplier.")
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @Operation(summary = "Add a new supplier", description = "Creates a new supplier record.")
    @PostMapping
    public ResponseEntity<SupplierDTO> addSupplier(@Valid @RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.ok(supplierService.addSupplier(supplierDTO));
    }

    @Operation(summary = "Update a supplier", description = "Updates the details of an existing supplier.")
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @Valid @RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, supplierDTO));
    }

    @Operation(summary = "Delete a supplier", description = "Removes a supplier from the system.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}