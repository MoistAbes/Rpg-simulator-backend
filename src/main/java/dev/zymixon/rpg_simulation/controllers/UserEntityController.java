package dev.zymixon.rpg_simulation.controllers;

import dev.zymixon.rpg_simulation.entities.UserEntity;
import dev.zymixon.rpg_simulation.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserEntityController {

    private final UserEntityService userService;

    @Autowired
    public UserEntityController(UserEntityService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
        System.out.println("USER: " + user);
        UserEntity userEntity = userService.registerUser(user);
        return ResponseEntity.ok(userEntity);
    }

    @GetMapping(value = "/login/{username}/{password}")
    private ResponseEntity<UserEntity> loginUser(@PathVariable String username, @PathVariable String password) {
        UserEntity userEntity = userService.loginUser(username, password);

        if (userEntity == null) {
            System.out.println("LOGIN SUCCESFULL");
        }else {
            System.out.println("LOGIN FAILED");
        }

        return ResponseEntity.ok(userEntity);
    }
}
