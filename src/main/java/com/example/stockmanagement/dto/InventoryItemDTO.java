package com.example.stockmanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class InventoryItemDTO {

    private Long id;

    @NotBlank(message = "O nome não pode estar vazio.")
    @Size(max = 255, message = "O nome não pode ter mais de 255 caracteres.")
    private String name;

    @Min(value = 0, message = "A quantidade não pode ser negativa.")
    private int quantity;

    @NotBlank(message = "A descrição não pode estar vazia.")
    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    private String description;

    @Min(value = 0, message = "O limiar de reposição não pode ser negativo.")
    private int reorderThreshold;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(int reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }
}