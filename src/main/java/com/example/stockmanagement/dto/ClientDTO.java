package com.example.stockmanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class ClientDTO {

    private Long id;

    @Size(max = 100, message = "O nome não pode ter mais de 100 caracteres.")
    private String name;

    @Size(max = 12)
    private String taxpayerNumber;

    private String city;
    private String street;
    private String doorNumber;
    private String postalCode;

    private String mainLandline;
    private String mainLandlineName;

    private String secondaryLandline;
    private String secondaryLandlineName;

    private String alternativeContact1;
    private String alternativeContact1Name;
    private String alternativeContact2;
    private String alternativeContact2Name;
    private String alternativeContact3;
    private String alternativeContact3Name;
    private String alternativeContact4;
    private String alternativeContact4Name;
    private String alternativeContact5;
    private String alternativeContact5Name;

    @Email
    private String email1;
    @Email
    private String email2;
    @Email
    private String email3;

    private String website;
    private String address;
    private String contactNumber;
    private String email;

    private LocalDateTime createdAt;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMainLandline() {
        return mainLandline;
    }

    public void setMainLandline(String mainLandline) {
        this.mainLandline = mainLandline;
    }

    public String getMainLandlineName() {
        return mainLandlineName;
    }

    public void setMainLandlineName(String mainLandlineName) {
        this.mainLandlineName = mainLandlineName;
    }

    public String getSecondaryLandline() {
        return secondaryLandline;
    }

    public void setSecondaryLandline(String secondaryLandline) {
        this.secondaryLandline = secondaryLandline;
    }

    public String getSecondaryLandlineName() {
        return secondaryLandlineName;
    }

    public void setSecondaryLandlineName(String secondaryLandlineName) {
        this.secondaryLandlineName = secondaryLandlineName;
    }

    public String getAlternativeContact1() {
        return alternativeContact1;
    }

    public void setAlternativeContact1(String alternativeContact1) {
        this.alternativeContact1 = alternativeContact1;
    }

    public String getAlternativeContact1Name() {
        return alternativeContact1Name;
    }

    public void setAlternativeContact1Name(String alternativeContact1Name) {
        this.alternativeContact1Name = alternativeContact1Name;
    }

    public String getAlternativeContact2() {
        return alternativeContact2;
    }

    public void setAlternativeContact2(String alternativeContact2) {
        this.alternativeContact2 = alternativeContact2;
    }

    public String getAlternativeContact2Name() {
        return alternativeContact2Name;
    }

    public void setAlternativeContact2Name(String alternativeContact2Name) {
        this.alternativeContact2Name = alternativeContact2Name;
    }

    public String getAlternativeContact3() {
        return alternativeContact3;
    }

    public void setAlternativeContact3(String alternativeContact3) {
        this.alternativeContact3 = alternativeContact3;
    }

    public String getAlternativeContact3Name() {
        return alternativeContact3Name;
    }

    public void setAlternativeContact3Name(String alternativeContact3Name) {
        this.alternativeContact3Name = alternativeContact3Name;
    }

    public String getAlternativeContact4() {
        return alternativeContact4;
    }

    public void setAlternativeContact4(String alternativeContact4) {
        this.alternativeContact4 = alternativeContact4;
    }

    public String getAlternativeContact4Name() {
        return alternativeContact4Name;
    }

    public void setAlternativeContact4Name(String alternativeContact4Name) {
        this.alternativeContact4Name = alternativeContact4Name;
    }

    public String getAlternativeContact5() {
        return alternativeContact5;
    }

    public void setAlternativeContact5(String alternativeContact5) {
        this.alternativeContact5 = alternativeContact5;
    }

    public String getAlternativeContact5Name() {
        return alternativeContact5Name;
    }

    public void setAlternativeContact5Name(String alternativeContact5Name) {
        this.alternativeContact5Name = alternativeContact5Name;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}