package com.example.stockmanagement.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Map;

public class ClientPreferenceDTO {

    private Long id; // Unique preference ID

    @NotNull(message = "O ID do cliente não pode ser nulo.")
    private Long clientId; // Associated client ID

    @NotNull(message = "O ID do produto não pode ser nulo.")
    private Long productId; // Associated product ID (coffin model)

    @NotNull(message = "Os detalhes da preferência não podem ser nulos.")
    private Map<String, Object> preferenceDetails; // Stores JSON for choices (e.g., wood, color)

    private LocalDateTime createdAt; // Read-only field for tracking creation date

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Map<String, Object> getPreferenceDetails() {
        return preferenceDetails;
    }

    public void setPreferenceDetails(Map<String, Object> preferenceDetails) {
        this.preferenceDetails = preferenceDetails;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}