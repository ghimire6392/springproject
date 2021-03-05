package com.biswas.springjanweb.user.service;

import com.biswas.springjanweb.user.entity.User;
import java.util.List;

public interface UserService {

    //abstract method
    User save(User user);

    List<User> finaAll();

    void delete(int id);

    User getUserById(int id);
}
