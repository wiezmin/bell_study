package ru.bellintegrator.organizationapi.service.interfaces;

import ru.bellintegrator.organizationapi.view.OfficeView;
import ru.bellintegrator.organizationapi.view.interfaces.View;

import java.util.List;

public interface Service {

    List<View> getAll(String[] params);

    void get(String id);

    void update(View view);

    void save(View view);

}
