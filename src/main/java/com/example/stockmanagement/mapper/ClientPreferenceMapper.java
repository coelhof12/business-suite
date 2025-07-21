package com.example.stockmanagement.mapper;

import com.example.stockmanagement.dto.ClientPreferenceDTO;
import com.example.stockmanagement.model.ClientPreference;
import org.springframework.stereotype.Component;

@Component
public class ClientPreferenceMapper {

    public static ClientPreferenceDTO toDTO(ClientPreference preference) {
        ClientPreferenceDTO dto = new ClientPreferenceDTO();
        dto.setId(preference.getId());
        dto.setClientId(preference.getClient().getId());
        dto.setProductId(preference.getProduct().getId());
        dto.setPreferenceDetails(preference.getPreferenceDetails());
        dto.setCreatedAt(preference.getCreatedAt());
        return dto;
    }

    public static ClientPreference toEntity(ClientPreferenceDTO dto) {
        ClientPreference preference = new ClientPreference();
        preference.setId(dto.getId());
        preference.setPreferenceDetails(dto.getPreferenceDetails());
        // Note: `client` and `product` should be fetched and set in the service layer
        return preference;
    }
}