package ru.bellintegrator.organizationapi.model.dto.classifiers;

import lombok.Data;

@Data
public class DocumentDto {

    private String code;

    private String name;

    @Override
    public String toString() {
        return "{name:" + name + ",code:" + code + "}";
    }

}
