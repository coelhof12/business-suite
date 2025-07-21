package com.example.stockmanagement.mapper;

import com.example.stockmanagement.dto.AlertDTO;
import com.example.stockmanagement.model.Alert;
import com.example.stockmanagement.model.InventoryItem;
import org.springframework.stereotype.Component;

@Component
public class AlertMapper {

    public static AlertDTO toDTO(Alert alert) {
        AlertDTO dto = new AlertDTO();
        dto.setId(alert.getId());
        dto.setInventoryItemId(alert.getInventoryItem().getId());
        dto.setMessage(alert.getMessage());
        dto.setCreatedAt(alert.getCreatedAt());
        return dto;
    }

    public static Alert toEntity(AlertDTO dto, InventoryItem inventoryItem) {
        Alert alert = new Alert();
        alert.setInventoryItem(inventoryItem); // Properly set the inventory item
        alert.setMessage(dto.getMessage());
        return alert;
    }
}