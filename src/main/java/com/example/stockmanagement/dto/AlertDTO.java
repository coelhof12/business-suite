package com.example.stockmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AlertDTO {

    private Long id; // Unique alert ID

    @NotNull(message = "O ID do item de inventário não pode ser nulo.")
    private Long inventoryItemId; // Associated inventory item ID

    @NotBlank(message = "A mensagem do alerta não pode estar vazia.")
    private String message; // Alert message

    private LocalDateTime createdAt; // Timestamp of alert creation (read-only)

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}