package com.example.stockmanagement.repository;

import com.example.stockmanagement.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    // Add custom queries here if needed in the future
}