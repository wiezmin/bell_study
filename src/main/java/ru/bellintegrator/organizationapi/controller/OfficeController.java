package ru.bellintegrator.organizationapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.organizationapi.model.entity.Office;
import ru.bellintegrator.organizationapi.service.OfficeServiceImpl;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("office")
public class OfficeController {

    //@Qualifier("officeServiceImpl")
    @Autowired
    private OfficeServiceImpl officeService;

    @PostMapping("/list")
    public List<Office> list(@RequestBody Office criteria) {
        return officeService.getAll(criteria);
    }

    @GetMapping("{id}")
    public Office getOneElement(@PathVariable String id) {
        return officeService.get(id);
    }

    @PutMapping("/update")
    public void update(@PathVariable Office newOfficeData) {
        officeService.update(newOfficeData);
    }

    @PostMapping("/save")
    public void save(@RequestBody Office office) {
        officeService.save(office);
    }


}
