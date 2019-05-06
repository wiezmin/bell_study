package ru.bellintegrator.organizationapi.model.dto;

import lombok.Data;

@Data
public class OfficeDto {

    public String orgId;

    public String name;

    public String address;

    public String phone;

    public boolean isActive;

    @Override
    public String toString() {
        return "{orgId:" + orgId
                + ",name:" + name
                + ",address:" + address
                + ",phone:" + phone
                + ",isActive:" + isActive
                + "}";
    }

}
