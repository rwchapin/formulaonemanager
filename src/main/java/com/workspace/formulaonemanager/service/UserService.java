package com.workspace.formulaonemanager.service;

import com.workspace.formulaonemanager.models.User;

public interface UserService {

    Iterable<User> getAllUsers();
    User getUser(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    User deleteUser(Long id);
}
