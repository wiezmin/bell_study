package ru.bellintegrator.organizationapi.dto.classifiers;

import lombok.Data;

@Data
public class CountryDto {

    public String code;

    public String name;

    @Override
    public String toString() {
        return "{name:" + name + ",code:" + code + "}";
    }
}
