package com.example.stockmanagement.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "client_preferences", indexes = {
        @Index(name = "idx_client_id", columnList = "client_id"),
        @Index(name = "idx_product_id", columnList = "product_id")
})
public class ClientPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private InventoryItem product;

    @Type(JsonBinaryType.class)  // Corrected way for Hibernate 6+
    @Column(name = "preference_details", columnDefinition = "jsonb", nullable = false)
    private Map<String, Object> preferenceDetails;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public InventoryItem getProduct() {
        return product;
    }

    public void setProduct(InventoryItem product) {
        this.product = product;
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