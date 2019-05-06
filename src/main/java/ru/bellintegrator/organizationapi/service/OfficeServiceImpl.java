package ru.bellintegrator.organizationapi.service;

import ru.bellintegrator.organizationapi.model.dto.OfficeDto;
import ru.bellintegrator.organizationapi.model.entity.Office;
import ru.bellintegrator.organizationapi.service.interfaces.Service;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service("userServiceImpl")
public class OfficeServiceImpl implements Service<Office> {

    private List<Office> offices = new ArrayList<>();

    @Override
    public List<Office> getAll(Office criteria) {
        offices.add(Office.builder()
                .id(2)
                .address("Москва, ул. Садовническая, 82, стр. 2")
                .isActive(true)
                .name("Дополнительный офис")
                .phone("+74957397000")
                .orgId(2)
                .build());

        List<Office> selectedOffices = new ArrayList<>();
        for (Office office:offices
             ) {
            if (office.getId() == criteria.getId()){
                selectedOffices.add(office);
            }
        }
        return selectedOffices;
    }

    @Override
    public Office get(String id) {
        for (Office office:offices
                ) {
            if (office.getId() == Integer.valueOf(id)){
                return office;
            }
        }
        return null;
    }

    @Override
    public void update(Office office) {
        Office.builder()
            .id(office.getId())
            .address(office.getAddress())
            .isActive(office.isActive())
            .name(office.getName())
            .phone(office.getPhone())
            .orgId(office.getOrgId())
            .build();
    }

    @Override
    public void save(Office office) {
        offices.add(office);
    }
}
