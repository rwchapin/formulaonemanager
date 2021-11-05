package com.workspace.formulaonemanager.controller;

import com.workspace.formulaonemanager.models.User;
import com.workspace.formulaonemanager.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @CrossOrigin
    @GetMapping
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if(!userOptional.isPresent()){
            return null;
        }
        User foundUser = userOptional.get();
        return foundUser;
    }

    @CrossOrigin
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setRole("USER");
        User newUser = this.userRepository.save(user);
        return newUser;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        Optional<User> userOptional = this.userRepository.findById(id);
        if(!userOptional.isPresent()){
            return null;
        }
        User userToUpdate = userOptional.get();
        if(user.getName() != null){
            userToUpdate.setName(user.getName());
        }
        if(user.getUsername() != null){
            userToUpdate.setUsername(user.getUsername());
        }
        if(user.getPassword() != null){
            userToUpdate.setPassword(user.getPassword());
        }
        if(user.getRole() != null){
            userToUpdate.setRole(user.getRole());
        }
       return null;
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") Long id){
        Optional<User> userOptional = this.userRepository.findById(id);
        if(!userOptional.isPresent()){
            return null;
        }
        User deleteUser = userOptional.get();
        this.userRepository.delete(deleteUser);
        return deleteUser;
    }



}
