package ru.bellintegrator.organizationapi.view;

import lombok.Builder;
import ru.bellintegrator.organizationapi.view.interfaces.View;

@Builder
public class OfficeView  implements View {

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
