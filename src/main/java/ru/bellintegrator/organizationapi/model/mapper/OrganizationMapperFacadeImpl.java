/*
 * Created by m.krasilnikov
 */

package ru.bellintegrator.organizationapi.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.organizationapi.model.dto.OrganizationDto;
import ru.bellintegrator.organizationapi.model.entity.Organization;
import ru.bellintegrator.organizationapi.service.OrganizationServiceImpl;

@Component("organizationMapperFacade")
public class OrganizationMapperFacadeImpl implements MapperFacade<OrganizationDto, Organization> {

    @Autowired
    private OrganizationServiceImpl organizationService;

    @Autowired
    private ModelMapper modelMapper;

    public OrganizationDto get(String id){
        return convertToDto(organizationService.get(id));
    }

    public void save(OrganizationDto organizationDto){
        organizationService.save(convertFromDto(organizationDto));
    }

    public void update(OrganizationDto organizationDto){
        organizationService.update(convertFromDto(organizationDto));
    }

    @Override
    public OrganizationDto convertToDto(Organization organization) {
        OrganizationDto organizationDto = modelMapper
                .map(organization, OrganizationDto.class);
        return organizationDto;
    }

    @Override
    public Organization convertFromDto(OrganizationDto organizationDto) {
        Organization organization = modelMapper
                .map(organizationDto, Organization.class);
        return organization;
    }
}
