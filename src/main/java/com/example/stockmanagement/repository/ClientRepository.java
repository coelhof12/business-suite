package com.example.stockmanagement.repository;

import com.example.stockmanagement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Add custom queries here if needed in the future
}