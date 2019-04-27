package ru.bellintegrator.organizationapi.entity;


import lombok.Builder;

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
