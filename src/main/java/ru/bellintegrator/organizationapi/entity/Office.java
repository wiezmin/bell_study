package ru.bellintegrator.organizationapi.entity;

import lombok.Builder;

@Builder
public class Office {

    private String orgId;

    private String name;

    private String phone;

    private boolean isActive;

}
