package com.example.stockmanagement.service;

import com.example.stockmanagement.dto.AlertDTO;
import com.example.stockmanagement.exceptions.InventoryItemNotFoundException;
import com.example.stockmanagement.mapper.AlertMapper;
import com.example.stockmanagement.model.Alert;
import com.example.stockmanagement.model.InventoryItem;
import com.example.stockmanagement.repository.AlertRepository;
import com.example.stockmanagement.repository.InventoryItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlertServiceTest {

    @Mock
    private AlertRepository alertRepository;

    @Mock
    private InventoryItemRepository inventoryItemRepository;

    @InjectMocks
    private AlertService alertService;

    private InventoryItem testItem;

    @BeforeEach
    void setUp() {
        testItem = new InventoryItem();
        testItem.setId(1L);
        testItem.setName("Test Item");
        testItem.setQuantity(5);
        testItem.setDescription("A test inventory item");
        testItem.setReorderThreshold(10);
    }

    @Test
    void testCreateLowStockAlert_Success() {
        when(inventoryItemRepository.findById(1L)).thenReturn(Optional.of(testItem));

        Alert mockAlert = new Alert();
        mockAlert.setId(1L);
        mockAlert.setInventoryItem(testItem);
        mockAlert.setMessage("Low stock alert!");

        when(alertRepository.save(any(Alert.class))).thenReturn(mockAlert);

        AlertDTO alertDTO = alertService.createLowStockAlert(1L, "Low stock alert!");

        assertNotNull(alertDTO);
        assertEquals("Low stock alert!", alertDTO.getMessage());
        assertEquals(1L, alertDTO.getInventoryItemId());

        verify(alertRepository, times(1)).save(any(Alert.class));
    }
}