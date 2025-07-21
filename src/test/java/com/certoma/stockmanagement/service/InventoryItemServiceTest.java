package com.example.stockmanagement.service;

import com.example.stockmanagement.dto.InventoryItemDTO;
import com.example.stockmanagement.exceptions.InventoryItemNotFoundException;
import com.example.stockmanagement.mapper.InventoryItemMapper;
import com.example.stockmanagement.model.InventoryItem;
import com.example.stockmanagement.repository.InventoryItemRepository;
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
class InventoryItemServiceTest {

    @Mock
    private InventoryItemRepository inventoryItemRepository;

    @InjectMocks
    private InventoryItemService inventoryItemService;

    private InventoryItem testItem;

    @BeforeEach
    void setUp() {
        testItem = new InventoryItem();
        testItem.setId(1L);
        testItem.setName("Wood");
        testItem.setQuantity(50);
        testItem.setDescription("High-quality wood for production");
        testItem.setReorderThreshold(10);
    }

    @Test
    void shouldReturnAllInventoryItems() {
        when(inventoryItemRepository.findAll()).thenReturn(Arrays.asList(testItem));

        List<InventoryItemDTO> result = inventoryItemService.getAllInventoryItems();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Wood", result.get(0).getName());

        verify(inventoryItemRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnInventoryItemById() {
        when(inventoryItemRepository.findById(1L)).thenReturn(Optional.of(testItem));

        InventoryItemDTO result = inventoryItemService.getInventoryItemById(1L);

        assertNotNull(result);
        assertEquals("Wood", result.getName());
        verify(inventoryItemRepository, times(1)).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenInventoryItemNotFound() {
        when(inventoryItemRepository.findById(2L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(InventoryItemNotFoundException.class, () -> {
            inventoryItemService.getInventoryItemById(2L);
        });

        assertEquals("Item de inventário não encontrado com o ID: 2", exception.getMessage());
        verify(inventoryItemRepository, times(1)).findById(2L);
    }
}