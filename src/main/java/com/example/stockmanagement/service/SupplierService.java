package com.example.stockmanagement.service;

import com.example.stockmanagement.dto.SupplierDTO;
import com.example.stockmanagement.exceptions.SupplierNotFoundException;
import com.example.stockmanagement.mapper.SupplierMapper;
import com.example.stockmanagement.model.Supplier;
import com.example.stockmanagement.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    // Get All Suppliers
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll()
                .stream()
                .map(SupplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get Supplier By ID
    public SupplierDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException("Fornecedor não encontrado com o ID: " + id));
        return SupplierMapper.toDTO(supplier);
    }

    // Add Supplier
    public SupplierDTO addSupplier(SupplierDTO dto) {
        if (supplierRepository.existsByName(dto.getName())) {
            throw new IllegalArgumentException("Já existe um fornecedor com este nome.");
        }

        if (supplierRepository.existsByStreetAndDoorNumberAndPostalCode(
                dto.getStreet(), dto.getDoorNumber(), dto.getPostalCode())) {
            throw new IllegalArgumentException("Já existe um fornecedor com esta morada.");
        }

        if (supplierRepository.existsByEmail1OrMainLandline(dto.getEmail1(), dto.getMainLandline())) {
            throw new IllegalArgumentException("Já existe um fornecedor com este email ou número de telefone.");
        }

        Supplier supplier = SupplierMapper.toEntity(dto);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return SupplierMapper.toDTO(savedSupplier);
    }

    // Update Supplier
    public SupplierDTO updateSupplier(Long id, SupplierDTO dto) {
        return supplierRepository.findById(id)
                .map(existingSupplier -> {
                    existingSupplier.setName(dto.getName());
                    existingSupplier.setCategory(dto.getCategory());
                    existingSupplier.setTaxpayerNumber(dto.getTaxpayerNumber());
                    existingSupplier.setCity(dto.getCity());
                    existingSupplier.setStreet(dto.getStreet());
                    existingSupplier.setDoorNumber(dto.getDoorNumber());
                    existingSupplier.setPostalCode(dto.getPostalCode());
                    existingSupplier.setMainLandline(dto.getMainLandline());
                    existingSupplier.setMainLandlineName(dto.getMainLandlineName());
                    existingSupplier.setSecondaryLandline(dto.getSecondaryLandline());
                    existingSupplier.setSecondaryLandlineName(dto.getSecondaryLandlineName());
                    existingSupplier.setAlternativeContact1(dto.getAlternativeContact1());
                    existingSupplier.setAlternativeContact1Name(dto.getAlternativeContact1Name());
                    existingSupplier.setAlternativeContact2(dto.getAlternativeContact2());
                    existingSupplier.setAlternativeContact2Name(dto.getAlternativeContact2Name());
                    existingSupplier.setAlternativeContact3(dto.getAlternativeContact3());
                    existingSupplier.setAlternativeContact3Name(dto.getAlternativeContact3Name());
                    existingSupplier.setAlternativeContact4(dto.getAlternativeContact4());
                    existingSupplier.setAlternativeContact4Name(dto.getAlternativeContact4Name());
                    existingSupplier.setAlternativeContact5(dto.getAlternativeContact5());
                    existingSupplier.setAlternativeContact5Name(dto.getAlternativeContact5Name());
                    existingSupplier.setEmail1(dto.getEmail1());
                    existingSupplier.setEmail2(dto.getEmail2());
                    existingSupplier.setEmail3(dto.getEmail3());
                    existingSupplier.setWebsite(dto.getWebsite());

                    return SupplierMapper.toDTO(supplierRepository.save(existingSupplier));
                })
                .orElseThrow(() -> new SupplierNotFoundException("Fornecedor não encontrado com o ID: " + id));
    }

    // Remove Supplier By ID
    public void deleteSupplier(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new SupplierNotFoundException("Fornecedor não encontrado com o ID: " + id);
        }
        supplierRepository.deleteById(id);
    }
}