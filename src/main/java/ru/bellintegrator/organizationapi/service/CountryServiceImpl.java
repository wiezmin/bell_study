package ru.bellintegrator.organizationapi.service;

import ru.bellintegrator.organizationapi.model.entity.classifiers.Country;
import ru.bellintegrator.organizationapi.service.interfaces.ClassifierService;

import java.util.List;

public class CountryServiceImpl implements ClassifierService<Country> {
    @Override
    public List<Country> getAll() {
        return null;
    }
}
