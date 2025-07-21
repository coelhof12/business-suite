package com.example.stockmanagement.mapper;

import com.example.stockmanagement.dto.SupplierDTO;
import com.example.stockmanagement.model.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    public static SupplierDTO toDTO(Supplier supplier) {
        SupplierDTO dto = new SupplierDTO();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setCategory(supplier.getCategory());
        dto.setTaxpayerNumber(supplier.getTaxpayerNumber());
        dto.setCity(supplier.getCity());
        dto.setStreet(supplier.getStreet());
        dto.setDoorNumber(supplier.getDoorNumber());
        dto.setPostalCode(supplier.getPostalCode());
        dto.setMainLandline(supplier.getMainLandline());
        dto.setMainLandlineName(supplier.getMainLandlineName());
        dto.setSecondaryLandline(supplier.getSecondaryLandline());
        dto.setSecondaryLandlineName(supplier.getSecondaryLandlineName());
        dto.setAlternativeContact1(supplier.getAlternativeContact1());
        dto.setAlternativeContact1Name(supplier.getAlternativeContact1Name());
        dto.setAlternativeContact2(supplier.getAlternativeContact2());
        dto.setAlternativeContact2Name(supplier.getAlternativeContact2Name());
        dto.setAlternativeContact3(supplier.getAlternativeContact3());
        dto.setAlternativeContact3Name(supplier.getAlternativeContact3Name());
        dto.setAlternativeContact4(supplier.getAlternativeContact4());
        dto.setAlternativeContact4Name(supplier.getAlternativeContact4Name());
        dto.setAlternativeContact5(supplier.getAlternativeContact5());
        dto.setAlternativeContact5Name(supplier.getAlternativeContact5Name());
        dto.setEmail1(supplier.getEmail1());
        dto.setEmail2(supplier.getEmail2());
        dto.setEmail3(supplier.getEmail3());
        dto.setWebsite(supplier.getWebsite());
        dto.setCreatedAt(supplier.getCreatedAt());
        return dto;
    }

    public static Supplier toEntity(SupplierDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setId(dto.getId());
        supplier.setName(dto.getName());
        supplier.setCategory(dto.getCategory());
        supplier.setTaxpayerNumber(dto.getTaxpayerNumber());
        supplier.setCity(dto.getCity());
        supplier.setStreet(dto.getStreet());
        supplier.setDoorNumber(dto.getDoorNumber());
        supplier.setPostalCode(dto.getPostalCode());
        supplier.setMainLandline(dto.getMainLandline());
        supplier.setMainLandlineName(dto.getMainLandlineName());
        supplier.setSecondaryLandline(dto.getSecondaryLandline());
        supplier.setSecondaryLandlineName(dto.getSecondaryLandlineName());
        supplier.setAlternativeContact1(dto.getAlternativeContact1());
        supplier.setAlternativeContact1Name(dto.getAlternativeContact1Name());
        supplier.setAlternativeContact2(dto.getAlternativeContact2());
        supplier.setAlternativeContact2Name(dto.getAlternativeContact2Name());
        supplier.setAlternativeContact3(dto.getAlternativeContact3());
        supplier.setAlternativeContact3Name(dto.getAlternativeContact3Name());
        supplier.setAlternativeContact4(dto.getAlternativeContact4());
        supplier.setAlternativeContact4Name(dto.getAlternativeContact4Name());
        supplier.setAlternativeContact5(dto.getAlternativeContact5());
        supplier.setAlternativeContact5Name(dto.getAlternativeContact5Name());
        supplier.setEmail1(dto.getEmail1());
        supplier.setEmail2(dto.getEmail2());
        supplier.setEmail3(dto.getEmail3());
        supplier.setWebsite(dto.getWebsite());
        supplier.setCreatedAt(dto.getCreatedAt());
        return supplier;
    }
}