package ru.bellintegrator.organizationapi.model.dto;


import lombok.Data;

@Data
public class OrganizationDto {

    private String id;

    private String name;

    private String fullName;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    private boolean isActive;

}
