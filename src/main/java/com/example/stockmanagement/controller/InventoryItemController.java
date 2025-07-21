package com.example.stockmanagement.controller;

import com.example.stockmanagement.dto.InventoryItemDTO;
import com.example.stockmanagement.service.InventoryItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory-items")
@Tag(name = "Inventory Items", description = "Endpoints for managing inventory items")
public class InventoryItemController {

    private final InventoryItemService inventoryItemService;

    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @Operation(summary = "Fetch all inventory items", description = "Retrieves a list of all inventory items in the system.")
    @GetMapping
    public ResponseEntity<List<InventoryItemDTO>> getAllInventoryItems() {
        return ResponseEntity.ok(inventoryItemService.getAllInventoryItems());
    }

    @Operation(summary = "Fetch an inventory item by ID", description = "Retrieves details of a specific inventory item.")
    @GetMapping("/{id}")
    public ResponseEntity<InventoryItemDTO> getInventoryItemById(@PathVariable Long id) {
        return ResponseEntity.ok(inventoryItemService.getInventoryItemById(id));
    }

    @Operation(summary = "Add a new inventory item", description = "Creates a new inventory item record.")
    @PostMapping
    public ResponseEntity<InventoryItemDTO> addInventoryItem(@RequestBody InventoryItemDTO inventoryItemDTO) {
        return ResponseEntity.ok(inventoryItemService.addInventoryItem(inventoryItemDTO));
    }

    @Operation(summary = "Update an inventory item", description = "Updates the details of an existing inventory item.")
    @PutMapping("/{id}")
    public ResponseEntity<InventoryItemDTO> updateInventoryItem(@PathVariable Long id, @RequestBody InventoryItemDTO inventoryItemDTO) {
        return ResponseEntity.ok(inventoryItemService.updateInventoryItem(id, inventoryItemDTO));
    }

    @Operation(summary = "Delete an inventory item", description = "Removes an inventory item from the system.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventoryItem(@PathVariable Long id) {
        inventoryItemService.deleteInventoryItem(id);
        return ResponseEntity.noContent().build();
    }
}