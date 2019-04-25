package ru.bellintegrator.organizationapi.view.classifiers;

import lombok.Data;
import ru.bellintegrator.organizationapi.view.interfaces.View;

@Data
public class DocumentView  implements View {


    private String code;

    private String name;

}
