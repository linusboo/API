package com.website.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.website.demo.Repo.UserRepo;
import com.website.demo.model.User;

@RestController
public class ApiControllers {
    
    @Autowired(required = true)
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public ResponseEntity<String> getString() {
        return ResponseEntity.ok("Hello World");
    } 
    @GetMapping(value = "/getUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepo.findAll();
        return ResponseEntity.ok(users);
    }
    @PostMapping("/saveUsers")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Saved");
    }
    
    @PutMapping("/editUser/{id}")
    public ResponseEntity<String>editUser(@RequestBody User newUser, @PathVariable long id) {
        return userRepo.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setUserName(newUser.getUserName());
                    user.setPassword(newUser.getPassword());
                    userRepo.save(user);
                    return ResponseEntity.ok("Edited user with " + id);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        userRepo.deleteById(id);
        return ResponseEntity.ok("User with " + id + " deleted");
    }
}