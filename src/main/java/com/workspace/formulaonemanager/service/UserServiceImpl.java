package com.workspace.formulaonemanager.service;

import com.workspace.formulaonemanager.models.User;
import com.workspace.formulaonemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            return null;
        }
        User foundUser = userOptional.get();
        return foundUser;
    }

    @Override
    public User createUser(User user) {
        user.setRole("USER");
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
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
        User updatedUser = userRepository.save(userToUpdate);
        return updatedUser;
    }

    @Override
    public User deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            return null;
        }
        User deleteUser = userOptional.get();
        userRepository.delete(deleteUser);
        return deleteUser;
    }
}
