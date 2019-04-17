package ru.bellintegrator.organizationapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthcheckController {

    @GetMapping("/version")
    public String version() {
        return "0.0.1-SNAPSHOT";
    }

}
