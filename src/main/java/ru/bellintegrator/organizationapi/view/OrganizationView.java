package ru.bellintegrator.organizationapi.view;


import lombok.Builder;
import ru.bellintegrator.organizationapi.view.interfaces.View;

@Builder
public class OrganizationView  implements View {

    //@NonNull - возможно норм тема
    private String name;

    private String fullName;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    private boolean isActive;

}
