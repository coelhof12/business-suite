package com.example.stockmanagement.service;

import com.example.stockmanagement.dto.ClientDTO;
import com.example.stockmanagement.exceptions.ClientNotFoundException;
import com.example.stockmanagement.mapper.ClientMapper;
import com.example.stockmanagement.model.Client;
import com.example.stockmanagement.repository.ClientRepository;
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
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client testClient;

    @BeforeEach
    void setUp() {
        testClient = new Client();
        testClient.setId(1L);
        testClient.setName("John Doe");
        testClient.setEmail("john.doe@example.com");
        testClient.setContactNumber("123456789");
        testClient.setAddress("123 Street, City");
    }

    @Test
    void shouldReturnAllClients() {
        when(clientRepository.findAll()).thenReturn(Arrays.asList(testClient));

        List<ClientDTO> result = clientService.getAllClients();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());

        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnClientById() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(testClient));

        ClientDTO result = clientService.getClientById(1L);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(clientRepository, times(1)).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenClientNotFound() {
        when(clientRepository.findById(2L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ClientNotFoundException.class, () -> {
            clientService.getClientById(2L);
        });

        assertEquals("Cliente não encontrado com o ID: 2", exception.getMessage());
        verify(clientRepository, times(1)).findById(2L);
    }
}