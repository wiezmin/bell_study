package ru.bellintegrator.organizationapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthcheckController {

    @Value("${application.name}")
    private String applicationName;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${build.timestamp}")
    private String buildTimestamp;

    @Value("${app.encoding}")
    private String appEncoding;

    @Value("${app.java.version}")
    private String appJavaVersion;

    @GetMapping("/info")
    public String info() {
        return "Application: " + applicationName
                + "<br> version: " + buildVersion
                + "<br> build time: " + buildTimestamp
                + "<br> Encoding: " + appEncoding
                + "<br> Java version: " + appJavaVersion;
    }

}
