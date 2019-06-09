package ru.bellintegrator.organizationapi.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrganizationDto {

    private String name;

    private String fullName;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    @JsonProperty("isActive")
    private String isActive;

}
