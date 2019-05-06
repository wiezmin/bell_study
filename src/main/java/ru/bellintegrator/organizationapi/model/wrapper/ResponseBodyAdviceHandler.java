/*
 * Created by m.krasilnikov
 */

package ru.bellintegrator.organizationapi.model.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.bellintegrator.organizationapi.model.dto.OfficeDto;
import ru.bellintegrator.organizationapi.model.mapper.OfficeMapperFacadeImpl;
import ru.bellintegrator.organizationapi.service.OfficeServiceImpl;

public class ResponseBodyAdviceHandler implements ResponseBodyAdvice<OfficeDto> {

    @Autowired
    OfficeMapperFacadeImpl officeMapperFacade;

    @Autowired
    OfficeServiceImpl officeService;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return false;
    }

    @Override
    public OfficeDto beforeBodyWrite(OfficeDto officeDto, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return officeMapperFacade.convertToDto(officeService.get("1"));
    }
}
