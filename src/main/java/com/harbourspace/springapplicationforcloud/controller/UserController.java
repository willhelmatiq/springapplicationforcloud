package com.harbourspace.springapplicationforcloud.controller;


import com.harbourspace.springapplicationforcloud.entity.AppUser;
import com.harbourspace.springapplicationforcloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public UserController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @PostMapping("/createuser")
    public ResponseEntity<String> createNewUser(@RequestBody AppUser appUser) {
        logger.info("trying to create new User");
        AppUser newAppUser = userService.createNewUser(appUser);
        amqpTemplate.convertAndSend("myQueue", newAppUser.toString());
        return ResponseEntity.ok("new user created");
    }
}
