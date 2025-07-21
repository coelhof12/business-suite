package com.example.stockmanagement.repository;

import com.example.stockmanagement.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    boolean existsByEmail1OrMainLandline(String email1, String mainLandline);

    boolean existsByName(String name);

    boolean existsByStreetAndDoorNumberAndPostalCode(String street, String doorNumber, String postalCode);
}