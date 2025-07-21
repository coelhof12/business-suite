package com.example.stockmanagement.service;

import com.example.stockmanagement.dto.SupplierDTO;
import com.example.stockmanagement.exceptions.SupplierNotFoundException;
import com.example.stockmanagement.mapper.SupplierMapper;
import com.example.stockmanagement.model.Supplier;
import com.example.stockmanagement.repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SupplierServiceTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierService supplierService;

    private Supplier testSupplier;

    @BeforeEach
    void setUp() {
        testSupplier = new Supplier();
        testSupplier.setId(1L);
        testSupplier.setName("Supplier One");
        testSupplier.setMainLandline("987654321");
        testSupplier.setEmail1("supplier@example.com");
        testSupplier.setStreet("Rua do Fornecedor");
        testSupplier.setDoorNumber("123");
        testSupplier.setPostalCode("1234-567");
        testSupplier.setCity("Anadia");
    }

    @Test
    void shouldReturnAllSuppliers() {
        when(supplierRepository.findAll()).thenReturn(Arrays.asList(testSupplier));

        List<SupplierDTO> result = supplierService.getAllSuppliers();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Supplier One", result.get(0).getName());

        verify(supplierRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnSupplierById() {
        when(supplierRepository.findById(1L)).thenReturn(Optional.of(testSupplier));

        SupplierDTO result = supplierService.getSupplierById(1L);

        assertNotNull(result);
        assertEquals("Supplier One", result.getName());
        verify(supplierRepository, times(1)).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenSupplierNotFound() {
        when(supplierRepository.findById(2L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(SupplierNotFoundException.class, () -> {
            supplierService.getSupplierById(2L);
        });

        assertEquals("Fornecedor não encontrado com o ID: 2", exception.getMessage());
        verify(supplierRepository, times(1)).findById(2L);
    }
}