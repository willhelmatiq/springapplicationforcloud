package com.harbourspace.springapplicationforcloud.healthcheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/healthcheck")
public class AppsHealthCheck {

    @GetMapping()
    public ResponseEntity<String> doHealthCheck() {
        return new ResponseEntity<>("I'm alive!!!", HttpStatus.OK);
    }
}
