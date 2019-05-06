/*
 * Created by m.krasilnikov
 */

package ru.bellintegrator.organizationapi.model.mapper;

public interface MapperFacade<Dto,Entity> {

    Dto convertToDto(Entity entity);

    Entity convertFromDto(Dto dto);
}
