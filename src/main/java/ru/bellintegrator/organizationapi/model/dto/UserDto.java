package ru.bellintegrator.organizationapi.model.dto;

import lombok.Data;

@Data
public class UserDto {
    
    private String officeId;

    private String firstName;

    private String secondName;

    private String middleName;

    private String position;

    private String phone;

    private String docCode;

    private String docName;

    private String docNumber;

    private String docDate;

    private String citizenshipCode;

    private boolean isIdentified;
    
}
