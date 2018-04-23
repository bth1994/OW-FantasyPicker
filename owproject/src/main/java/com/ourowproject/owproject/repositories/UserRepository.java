package com.ourowproject.owproject.repositories;

import com.ourowproject.owproject.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
