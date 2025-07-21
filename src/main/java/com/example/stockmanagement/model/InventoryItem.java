package com.example.stockmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "inventory_items", indexes = {
        @Index(name = "idx_item_name", columnList = "name"),
        @Index(name = "idx_item_quantity", columnList = "quantity")
})
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar vazio.")
    @Size(max = 255, message = "O nome não pode ter mais de 255 caracteres.")
    @Column(nullable = false)
    private String name;

    @Min(value = 0, message = "A quantidade não pode ser negativa.")
    @Column(nullable = false)
    private int quantity;

    @NotBlank(message = "A descrição não pode estar vazia.")
    @Size(max = 255, message = "A descrição não pode ter mais de 255 caracteres.")
    @Column(nullable = false)
    private String description;

    @Min(value = 0, message = "O limite de reposição não pode ser negativo.")
    @Column(name = "reorder_threshold", nullable = false)
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