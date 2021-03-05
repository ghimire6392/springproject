package com.biswas.springjanweb;

import com.biswas.springjanweb.user.entity.User;
import com.biswas.springjanweb.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringjanwebApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringjanwebApplication.class, args);
    }

    @PostConstruct
    public void createAdminUser() {
        String adminUserName ="admin@admin.com";

        User adminUser = userRepository.findByEmail(adminUserName);
        if (null == adminUser) {
            User user = new User();
            final String defaultPsswd = "1234";
            user.setName("administrator");
            user.setEmail(adminUserName);
            user.setPassword(passwordEncoder.encode(defaultPsswd));
            userRepository.save(user);
        }

    }

}
