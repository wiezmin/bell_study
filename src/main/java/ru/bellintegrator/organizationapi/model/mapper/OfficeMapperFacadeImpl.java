/*
 * Created by m.krasilnikov
 */

package ru.bellintegrator.organizationapi.model.mapper;

import ru.bellintegrator.organizationapi.model.dto.OfficeDto;
import ru.bellintegrator.organizationapi.model.entity.Office;

public class OfficeMapperFacadeImpl implements MapperFacade<OfficeDto, Office> {

    @Override
    public OfficeDto convertToDto(Office office) {
        return null;
    }

    @Override
    public Office convertFromDto(OfficeDto officeDto) {
        return null;
    }
}
