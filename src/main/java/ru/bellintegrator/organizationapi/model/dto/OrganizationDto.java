package ru.bellintegrator.organizationapi.model.dto;


import lombok.Data;

@Data
public class OrganizationDto {

    //@NonNull - возможно норм тема
    private String name;

    private String fullName;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    private boolean isActive;

}
