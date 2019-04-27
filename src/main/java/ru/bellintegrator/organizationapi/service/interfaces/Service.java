package ru.bellintegrator.organizationapi.service.interfaces;

import java.util.List;

public interface Service<D> {

    List<D> getAll(D dto);

    void get(String id);

    void update(D dto);

    void save(D dto);

}
