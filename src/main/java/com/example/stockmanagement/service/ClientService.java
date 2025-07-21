package com.example.stockmanagement.service;

import com.example.stockmanagement.dto.ClientDTO;
import com.example.stockmanagement.exceptions.ClientNotFoundException;
import com.example.stockmanagement.mapper.ClientMapper;
import com.example.stockmanagement.model.Client;
import com.example.stockmanagement.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Fetch all clients
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Fetch a single client by ID
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado com o ID: " + id));
        return ClientMapper.toDTO(client);
    }

    // Add a new client
    public ClientDTO addClient(ClientDTO clientDTO) {
        Client client = ClientMapper.toEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return ClientMapper.toDTO(savedClient);
    }

    // Update an existing client
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client updatedClient = ClientMapper.toEntity(clientDTO);
        return clientRepository.findById(id)
                .map(existingClient -> {
                    existingClient.setName(clientDTO.getName());
                    existingClient.setContactNumber(clientDTO.getContactNumber());
                    existingClient.setEmail(clientDTO.getEmail());
                    existingClient.setAddress(clientDTO.getAddress());
                    return ClientMapper.toDTO(clientRepository.save(existingClient));
                })
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado com o ID: " + id));
    }

    // Delete a client by ID
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException("Cliente não encontrado com o ID: " + id);
        }
        clientRepository.deleteById(id);
    }
}