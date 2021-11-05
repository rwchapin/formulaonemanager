package com.workspace.formulaonemanager.repositories;

import com.workspace.formulaonemanager.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
