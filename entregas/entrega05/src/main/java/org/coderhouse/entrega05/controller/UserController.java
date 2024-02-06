package org.coderhouse.entrega05.controller;

import org.coderhouse.entrega05.entity.UserModel;
import org.coderhouse.entrega05.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "users", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUsers() {
        List<UserModel> foundUsers = userService.getUsers();
        if (!foundUsers.isEmpty()) {
            return ResponseEntity.ok(foundUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "users", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addUser(@RequestBody UserModel user) {
        try {
            UserModel addedUser = userService.addUser(user);
            return ResponseEntity.created(URI.create("")).body(addedUser);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "users/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUserByID(@PathVariable(name = "id") Long id) {
        Optional<UserModel> foundUser = userService.getUserByID(id);
        if (foundUser.isPresent()) {
            return ResponseEntity.ok(foundUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "users/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateUser(@PathVariable(name = "id") Long id, @RequestBody UserModel user) {
        Optional<UserModel> foundUser = userService.getUserByID(id);
        if (foundUser.isPresent()) {
            UserModel modifiedUser = userService.updateUser(foundUser.get(), user);
            return ResponseEntity.ok(modifiedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "users/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long id) {
        Optional<UserModel> foundUser = userService.getUserByID(id);
        if (foundUser.isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
