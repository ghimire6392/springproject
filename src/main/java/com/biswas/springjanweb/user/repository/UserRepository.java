package com.biswas.springjanweb.user.repository;

import com.biswas.springjanweb.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String emailAsUsername);

    User findByName(String name);

}
