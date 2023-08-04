package org.fasttrackit.finalrockpaperscissors.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {
    @GetMapping("/getInfo")
    public String getBackendInfo() {
        String host = "http:localhost/8080";
        String projectName = "finalrockpaperscissors";

        return "Host: " + host + ", Project Name: " + projectName;
    }
}
