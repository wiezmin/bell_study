package ru.bellintegrator.organizationapi.view;

import lombok.Builder;
import ru.bellintegrator.organizationapi.view.interfaces.View;

@Builder
public class UserView  implements View {
    
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
