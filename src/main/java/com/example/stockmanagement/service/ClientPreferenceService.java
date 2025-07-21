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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientPreferenceService {

    private final ClientPreferenceRepository preferenceRepository;
    private final ClientRepository clientRepository;
    private final InventoryItemRepository inventoryItemRepository;

    public ClientPreferenceService(ClientPreferenceRepository preferenceRepository,
                                   ClientRepository clientRepository,
                                   InventoryItemRepository inventoryItemRepository) {
        this.preferenceRepository = preferenceRepository;
        this.clientRepository = clientRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    // Fetch all preferences for a client
    public List<ClientPreferenceDTO> getPreferencesByClientId(Long clientId) {
        return preferenceRepository.findAllByClientId(clientId)
                .stream()
                .map(ClientPreferenceMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Add a new preference for a client
    public ClientPreferenceDTO addPreference(ClientPreferenceDTO dto) {
        // Validate and fetch related entities
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado com o ID: " + dto.getClientId()));

        InventoryItem product = inventoryItemRepository.findById(dto.getProductId())
                .orElseThrow(() -> new InventoryItemNotFoundException("Produto não encontrado com o ID: " + dto.getProductId()));

        // Check for existing preference
        if (preferenceRepository.existsByClientIdAndProductId(client.getId(), product.getId())) {
            throw new PreferenceAlreadyExistsException("Já existe uma preferência para este cliente e produto.");
        }

        // Convert DTO to entity and save
        ClientPreference preference = ClientPreferenceMapper.toEntity(dto);
        preference.setClient(client);
        preference.setProduct(product);

        ClientPreference savedPreference = preferenceRepository.save(preference);
        return ClientPreferenceMapper.toDTO(savedPreference);
    }

    // Update a preference
    public ClientPreferenceDTO updatePreference(Long id, ClientPreferenceDTO updatedPreferenceDTO) {
        ClientPreference preference = preferenceRepository.findById(id)
                .orElseThrow(() -> new PreferenceNotFoundException("Preferência não encontrada com o ID: " + id));

        // Update details
        preference.setPreferenceDetails(updatedPreferenceDTO.getPreferenceDetails());

        ClientPreference updatedPreference = preferenceRepository.save(preference);
        return ClientPreferenceMapper.toDTO(updatedPreference);
    }

    // Delete a preference by ID
    public void deletePreference(Long id) {
        if (!preferenceRepository.existsById(id)) {
            throw new PreferenceNotFoundException("Preferência não encontrada com o ID: " + id);
        }
        preferenceRepository.deleteById(id);
    }
}