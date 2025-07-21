package com.example.stockmanagement.repository;

import com.example.stockmanagement.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {
}