package com.example.stockmanagement.repository;

import com.example.stockmanagement.model.ClientPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ClientPreferenceRepository extends JpaRepository<ClientPreference, Long> {

    // Find all preferences associated with a specific client
    List<ClientPreference> findAllByClientId(Long clientId);

    // Check if a preference exists for a client and a specific product
    boolean existsByClientIdAndProductId(Long clientId, Long productId);

    // Find a specific preference by client and product IDs
    Optional<ClientPreference> findByClientIdAndProductId(Long clientId, Long productId);
}