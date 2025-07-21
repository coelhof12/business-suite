package com.example.stockmanagement.service;

import com.example.stockmanagement.dto.AlertDTO;
import com.example.stockmanagement.exceptions.InventoryItemNotFoundException;
import com.example.stockmanagement.mapper.AlertMapper;
import com.example.stockmanagement.model.Alert;
import com.example.stockmanagement.model.InventoryItem;
import com.example.stockmanagement.repository.AlertRepository;
import com.example.stockmanagement.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlertService {

    private final AlertRepository alertRepository;
    private final InventoryItemRepository inventoryItemRepository;

    public AlertService(AlertRepository alertRepository, InventoryItemRepository inventoryItemRepository) {
        this.alertRepository = alertRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    // GET all alerts and convert into DTO
    public List<AlertDTO> getAllAlerts() {
        return alertRepository.findAll()
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Create new low stock alert manually
    public AlertDTO createLowStockAlert(Long inventoryItemId, String message) {
        InventoryItem inventoryItem = inventoryItemRepository.findById(inventoryItemId)
                .orElseThrow(() -> new InventoryItemNotFoundException("Item de inventário não encontrado com o ID: " + inventoryItemId));

        AlertDTO dto = new AlertDTO();
        dto.setInventoryItemId(inventoryItemId);
        dto.setMessage(message);

        Alert alert = AlertMapper.toEntity(dto, inventoryItem);

        return AlertMapper.toDTO(alertRepository.save(alert));
    }

    // Create alert automatically if one doesn't exist already
    public void createAlertIfNotExists(InventoryItem inventoryItem) {
        boolean exists = alertRepository.findAll().stream()
                .anyMatch(alert -> alert.getInventoryItem().getId().equals(inventoryItem.getId()));

        if (!exists) {
            Alert alert = new Alert();
            alert.setInventoryItem(inventoryItem);
            alert.setMessage("Stock crítico: " + inventoryItem.getName());
            alertRepository.save(alert);
        }
    }

    // Remove alert if it exists (e.g., stock replenished)
    public void removeAlertIfExists(InventoryItem inventoryItem) {
        List<Alert> alertsToRemove = alertRepository.findAll().stream()
                .filter(alert -> alert.getInventoryItem().getId().equals(inventoryItem.getId()))
                .collect(Collectors.toList());

        if (!alertsToRemove.isEmpty()) {
            alertRepository.deleteAll(alertsToRemove);
        }
    }
}
