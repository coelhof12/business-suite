package com.example.stockmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name", nullable = false, unique = true)
    private String name;

    @Column(name = "taxpayer_number")
    private String taxpayerNumber;

    @Column(name = "city_name")
    private String city;

    @Column(name = "street_name")
    private String street;

    @Column(name = "door_number")
    private String doorNumber;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "main_landline")
    private String mainLandline;

    @Column(name = "main_landline_name")
    private String mainLandlineName;

    @Column(name = "secondary_landline")
    private String secondaryLandline;

    @Column(name = "secondary_landline_name")
    private String secondaryLandlineName;

    @Column(name = "alternative_contact_1")
    private String alternativeContact1;

    @Column(name = "alternative_contact_1_name")
    private String alternativeContact1Name;

    @Column(name = "alternative_contact_2")
    private String alternativeContact2;

    @Column(name = "alternative_contact_2_name")
    private String alternativeContact2Name;

    @Column(name = "alternative_contact_3")
    private String alternativeContact3;

    @Column(name = "alternative_contact_3_name")
    private String alternativeContact3Name;

    @Column(name = "alternative_contact_4")
    private String alternativeContact4;

    @Column(name = "alternative_contact_4_name")
    private String alternativeContact4Name;

    @Column(name = "alternative_contact_5")
    private String alternativeContact5;

    @Column(name = "alternative_contact_5_name")
    private String alternativeContact5Name;

    @Email
    @Column(name = "email_1")
    private String email1;

    @Email
    @Column(name = "email_2")
    private String email2;

    @Email
    @Column(name = "email_3")
    private String email3;

    private String website;

    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Email
    private String email;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

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
