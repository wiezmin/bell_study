package ru.bellintegrator.organizationapi.model;

import lombok.Builder;

@Builder
public class Office {

    private String orgId;

    private String name;

    private String phone;

    private boolean isActive;

}
