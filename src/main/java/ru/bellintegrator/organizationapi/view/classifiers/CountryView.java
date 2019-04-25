package ru.bellintegrator.organizationapi.view.classifiers;

import ru.bellintegrator.organizationapi.view.interfaces.View;

public class CountryView implements View {

    public String code;

    public String name;

    @Override
    public String toString() {
        return "{name:" + name + ",code:" + code + "}";
    }
}
