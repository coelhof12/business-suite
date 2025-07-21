package com.example.stockmanagement.service;

import com.example.stockmanagement.dto.ClientPreferenceDTO;
import com.example.stockmanagement.exceptions.ClientNotFoundException;
import com.example.stockmanagement.exceptions.InventoryItemNotFoundException;
import com.example.stockmanagement.exceptions.PreferenceAlreadyExistsException;
import com.example.stockmanagement.exceptions.PreferenceNotFoundException;
import com.example.stockmanagement.mapper.ClientPreferenceMapper;
import com.example.stockmanagement.model.ClientPreference;
import com.example.stockmanagement.model.Client;
import com.example.stockmanagement.model.InventoryItem;
import com.example.stockmanagement.repository.ClientPreferenceRepository;
import com.example.stockmanagement.repository.ClientRepository;
import com.example.stockmanagement.repository.InventoryItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientPreferenceServiceTest {

    @Mock
    private ClientPreferenceRepository preferenceRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private InventoryItemRepository inventoryItemRepository;

    @InjectMocks
    private ClientPreferenceService clientPreferenceService;

    private Client testClient;
    private InventoryItem testProduct;
    private ClientPreference testPreference;

    @BeforeEach
    void setUp() {
        testClient = new Client();
        testClient.setId(1L);
        testClient.setName("John Doe");

        testProduct = new InventoryItem();
        testProduct.setId(1L);
        testProduct.setName("Pine Wood");

        testPreference = new ClientPreference();
        testPreference.setId(1L);
        testPreference.setClient(testClient);
        testPreference.setProduct(testProduct);
        testPreference.setPreferenceDetails(new HashMap<>(Map.of("color", "Brown")));
    }

    @Test
    void shouldReturnPreferencesByClientId() {
        when(preferenceRepository.findAllByClientId(1L)).thenReturn(List.of(testPreference));

        List<ClientPreferenceDTO> result = clientPreferenceService.getPreferencesByClientId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Brown", result.get(0).getPreferenceDetails().get("color"));
        verify(preferenceRepository, times(1)).findAllByClientId(1L);
    }

    @Test
    void shouldAddNewPreference() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(testClient));
        when(inventoryItemRepository.findById(1L)).thenReturn(Optional.of(testProduct));
        when(preferenceRepository.existsByClientIdAndProductId(1L, 1L)).thenReturn(false);
        when(preferenceRepository.save(any(ClientPreference.class))).thenReturn(testPreference);

        ClientPreferenceDTO dto = new ClientPreferenceDTO();
        dto.setClientId(1L);
        dto.setProductId(1L);
        dto.setPreferenceDetails(new HashMap<>(Map.of("color", "Brown")));

        ClientPreferenceDTO result = clientPreferenceService.addPreference(dto);

        assertNotNull(result);
        assertEquals("Brown", result.getPreferenceDetails().get("color"));
        verify(preferenceRepository, times(1)).save(any(ClientPreference.class));
    }

    @Test
    void shouldThrowExceptionWhenClientNotFound() {
        when(clientRepository.findById(2L)).thenReturn(Optional.empty());

        ClientPreferenceDTO dto = new ClientPreferenceDTO();
        dto.setClientId(2L);
        dto.setProductId(1L);
        dto.setPreferenceDetails(new HashMap<>(Map.of("color", "Brown")));

        Exception exception = assertThrows(ClientNotFoundException.class, () -> {
            clientPreferenceService.addPreference(dto);
        });

        assertEquals("Cliente não encontrado com o ID: 2", exception.getMessage());
        verify(preferenceRepository, never()).save(any(ClientPreference.class));
    }

    @Test
    void shouldThrowExceptionWhenPreferenceAlreadyExists() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(testClient));
        when(inventoryItemRepository.findById(1L)).thenReturn(Optional.of(testProduct));
        when(preferenceRepository.existsByClientIdAndProductId(1L, 1L)).thenReturn(true);

        ClientPreferenceDTO dto = new ClientPreferenceDTO();
        dto.setClientId(1L);
        dto.setProductId(1L);
        dto.setPreferenceDetails(new HashMap<>(Map.of("color", "Brown")));

        Exception exception = assertThrows(PreferenceAlreadyExistsException.class, () -> {
            clientPreferenceService.addPreference(dto);
        });

        assertEquals("Já existe uma preferência para este cliente e produto.", exception.getMessage());
        verify(preferenceRepository, never()).save(any(ClientPreference.class));
    }
}