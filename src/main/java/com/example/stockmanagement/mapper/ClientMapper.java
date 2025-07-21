package com.example.stockmanagement.mapper;

import com.example.stockmanagement.dto.ClientDTO;
import com.example.stockmanagement.model.Client;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;

@Component
public class ClientMapper {

    public static ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setTaxpayerNumber(client.getTaxpayerNumber());
        dto.setCity(client.getCity());
        dto.setStreet(client.getStreet());
        dto.setDoorNumber(client.getDoorNumber());
        dto.setPostalCode(client.getPostalCode());
        dto.setMainLandline(client.getMainLandline());
        dto.setMainLandlineName(client.getMainLandlineName());
        dto.setSecondaryLandline(client.getSecondaryLandline());
        dto.setSecondaryLandlineName(client.getSecondaryLandlineName());
        dto.setAlternativeContact1(client.getAlternativeContact1());
        dto.setAlternativeContact1Name(client.getAlternativeContact1Name());
        dto.setAlternativeContact2(client.getAlternativeContact2());
        dto.setAlternativeContact2Name(client.getAlternativeContact2Name());
        dto.setAlternativeContact3(client.getAlternativeContact3());
        dto.setAlternativeContact3Name(client.getAlternativeContact3Name());
        dto.setAlternativeContact4(client.getAlternativeContact4());
        dto.setAlternativeContact4Name(client.getAlternativeContact4Name());
        dto.setAlternativeContact5(client.getAlternativeContact5());
        dto.setAlternativeContact5Name(client.getAlternativeContact5Name());
        dto.setEmail1(client.getEmail1());
        dto.setEmail2(client.getEmail2());
        dto.setEmail3(client.getEmail3());
        dto.setWebsite(client.getWebsite());
        dto.setAddress(client.getAddress());
        dto.setContactNumber(client.getContactNumber());
        dto.setEmail(client.getEmail());

        if (client.getCreatedAt() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            dto.setCreatedAt(client.getCreatedAt());
        }
        return dto;
    }

    public static Client toEntity(ClientDTO dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setName(dto.getName());
        client.setTaxpayerNumber(dto.getTaxpayerNumber());
        client.setCity(dto.getCity());
        client.setStreet(dto.getStreet());
        client.setDoorNumber(dto.getDoorNumber());
        client.setPostalCode(dto.getPostalCode());
        client.setMainLandline(dto.getMainLandline());
        client.setMainLandlineName(dto.getMainLandlineName());
        client.setSecondaryLandline(dto.getSecondaryLandline());
        client.setSecondaryLandlineName(dto.getSecondaryLandlineName());
        client.setAlternativeContact1(dto.getAlternativeContact1());
        client.setAlternativeContact1Name(dto.getAlternativeContact1Name());
        client.setAlternativeContact2(dto.getAlternativeContact2());
        client.setAlternativeContact2Name(dto.getAlternativeContact2Name());
        client.setAlternativeContact3(dto.getAlternativeContact3());
        client.setAlternativeContact3Name(dto.getAlternativeContact3Name());
        client.setAlternativeContact4(dto.getAlternativeContact4());
        client.setAlternativeContact4Name(dto.getAlternativeContact4Name());
        client.setAlternativeContact5(dto.getAlternativeContact5());
        client.setAlternativeContact5Name(dto.getAlternativeContact5Name());
        client.setEmail1(dto.getEmail1());
        client.setEmail2(dto.getEmail2());
        client.setEmail3(dto.getEmail3());
        client.setWebsite(dto.getWebsite());
        client.setAddress(dto.getAddress());
        client.setContactNumber(dto.getContactNumber());
        client.setEmail(dto.getEmail());
        return client;
    }
}
