/*
 * Created by m.krasilnikov
 */

package ru.bellintegrator.organizationapi.service;


import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.organizationapi.dao.OrganizationRepository;
import ru.bellintegrator.organizationapi.model.entity.Organization;
import ru.bellintegrator.organizationapi.service.interfaces.Service;

import java.util.List;


@org.springframework.stereotype.Service("organizationServiceImpl")
public class OrganizationServiceImpl implements Service<Organization> {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<Organization> getAll(Organization criteria) {
        return organizationRepository.findByNameOrInnOrIsActive(
                criteria.getName(),
                criteria.getInn(),
                criteria.isActive());
    }

    @Override
    public Organization get(String id) {
        return organizationRepository.getOne(Integer.valueOf(id));
    }

    @Override
    public void update(Organization organization) {
        Organization organizationToUpdate = organizationRepository.getOne(organization.getId());
         if (!organization.getPhone().isEmpty()){
             organizationToUpdate.setPhone(organization.getPhone());
         }
         if (organization.isActive()){
             organizationToUpdate.setActive(true);
         }

         //TODO: ДОДЕЛАТЬ
         organizationToUpdate.setName(organization.getName());
         organizationToUpdate.setFullName(organization.getFullName());

         organizationRepository.save(organizationToUpdate);
    }

    @Override
    public void save(Organization organization) {
        organizationRepository.save(organization);
    }
}
