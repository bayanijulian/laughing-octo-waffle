package com.pacebank.app;

import java.util.List;
import com.pacebank.app.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByEmail(String email);
}