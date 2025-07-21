package com.example.stockmanagement.mapper;

import com.example.stockmanagement.dto.InventoryItemDTO;
import com.example.stockmanagement.model.InventoryItem;
import org.springframework.stereotype.Component;

@Component
public class InventoryItemMapper {

    public static InventoryItemDTO toDTO(InventoryItem inventoryItem) {
        InventoryItemDTO dto = new InventoryItemDTO();
        dto.setId(inventoryItem.getId());
        dto.setName(inventoryItem.getName());
        dto.setQuantity(inventoryItem.getQuantity());
        dto.setDescription(inventoryItem.getDescription());
        dto.setReorderThreshold(inventoryItem.getReorderThreshold());
        return dto;
    }

    public static InventoryItem toEntity(InventoryItemDTO dto) {
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setId(dto.getId());
        inventoryItem.setName(dto.getName());
        inventoryItem.setQuantity(dto.getQuantity());
        inventoryItem.setDescription(dto.getDescription());
        inventoryItem.setReorderThreshold(dto.getReorderThreshold());
        return inventoryItem;
    }
}