package ru.bellintegrator.organizationapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.organizationapi.model.dto.OrganizationDto;
import ru.bellintegrator.organizationapi.model.dto.Response;
import ru.bellintegrator.organizationapi.model.entity.Organization;
import ru.bellintegrator.organizationapi.model.mapper.OrganizationMapperFacadeImpl;
import ru.bellintegrator.organizationapi.service.OrganizationServiceImpl;

import java.util.List;


@RestController
@RequestMapping("organization")
public class OrganizationController {

    private static final Logger logger = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationServiceImpl organizationService;

    @Autowired
    private OrganizationMapperFacadeImpl organizationMapperFacade;

    @PostMapping("/list")
    public ResponseEntity<List<Organization>> list(
            @RequestBody Organization criteria){
        logger.info("Returning all organizations by criteria");
        return new ResponseEntity<List<Organization>>(organizationService.getAll(criteria), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> save(
            @RequestBody OrganizationDto organizationDto){
        organizationMapperFacade.save(organizationDto);
        logger.info("Save new organization");
        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Organization has been saved"),
                HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> update(
            @RequestBody OrganizationDto organizationDto){
        organizationMapperFacade.update(organizationDto);
        logger.info("Update some organization");
        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Organization has been updated"),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrganizationDto> getOneElement(
            @PathVariable String id){
        logger.info("Returning one organization by id");
        return new ResponseEntity<OrganizationDto>(organizationMapperFacade.get(id), HttpStatus.OK);
    }
}
