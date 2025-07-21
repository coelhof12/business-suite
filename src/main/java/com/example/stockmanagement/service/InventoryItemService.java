package com.example.stockmanagement.service;

import com.example.stockmanagement.dto.InventoryItemDTO;
import com.example.stockmanagement.exceptions.InventoryItemNotFoundException;
import com.example.stockmanagement.mapper.InventoryItemMapper;
import com.example.stockmanagement.model.InventoryItem;
import com.example.stockmanagement.repository.InventoryItemRepository;
import com.example.stockmanagement.service.AlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;
    private final AlertService alertService;

    public InventoryItemService(InventoryItemRepository inventoryItemRepository, AlertService alertService) {
        this.inventoryItemRepository = inventoryItemRepository;
        this.alertService = alertService;
    }

    // Fetch all inventory items
    public List<InventoryItemDTO> getAllInventoryItems() {
        return inventoryItemRepository.findAll()
                .stream()
                .map(InventoryItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Fetch a single inventory item by ID
    public InventoryItemDTO getInventoryItemById(Long id) {
        InventoryItem inventoryItem = inventoryItemRepository.findById(id)
                .orElseThrow(() -> new InventoryItemNotFoundException("Item de inventário não encontrado com o ID: " + id));
        return InventoryItemMapper.toDTO(inventoryItem);
    }

    // Add a new inventory item
    public InventoryItemDTO addInventoryItem(InventoryItemDTO dto) {
        InventoryItem inventoryItem = InventoryItemMapper.toEntity(dto);
        InventoryItem savedItem = inventoryItemRepository.save(inventoryItem);

        // Check new alert creation need
        handleAlertCheck(savedItem);

        return InventoryItemMapper.toDTO(savedItem);
    }

    // Update an existing inventory item
    public InventoryItemDTO updateInventoryItem(Long id, InventoryItemDTO dto) {
        InventoryItem updatedItem = InventoryItemMapper.toEntity(dto);
        return inventoryItemRepository.findById(id)
                .map(existingItem -> {
                    existingItem.setName(updatedItem.getName());
                    existingItem.setQuantity(updatedItem.getQuantity());
                    existingItem.setDescription(updatedItem.getDescription());
                    existingItem.setReorderThreshold(updatedItem.getReorderThreshold());

                    InventoryItem savedItem = inventoryItemRepository.save(existingItem);
                    handleAlertCheck(savedItem); // Checks if an alert should be created or removed
                    return InventoryItemMapper.toDTO(savedItem);
                })
                .orElseThrow(() -> new InventoryItemNotFoundException("Item de inventário não encontrado com o ID: " + id));
    }

    // Delete an inventory item by ID
    public void deleteInventoryItem(Long id) {
        if (!inventoryItemRepository.existsById(id)) {
            throw new InventoryItemNotFoundException("Item de inventário não encontrado com o ID: " + id);
        }
        inventoryItemRepository.deleteById(id);
    }

    // Checks if an alert should be created or removed
    private void handleAlertCheck(InventoryItem item) {
        if (item.getQuantity() <= item.getReorderThreshold()) {
            alertService.createAlertIfNotExists(item);
        } else {
            alertService.removeAlertIfExists(item);
        }
    }
}