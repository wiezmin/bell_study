package ru.bellintegrator.organizationapi.model;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
public class Organization {

    //@NonNull - возможно норм тема
    private String name;

    private String fullName;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    private boolean isActive;

}
