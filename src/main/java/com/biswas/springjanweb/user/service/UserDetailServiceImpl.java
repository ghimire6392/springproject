package com.biswas.springjanweb.user.service;

import com.biswas.springjanweb.core.config.security.UserDetailBean;
import com.biswas.springjanweb.user.entity.User;
import com.biswas.springjanweb.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if (null == user) {
            throw new RuntimeException("User does not exits under username " +username);
        }
        return new UserDetailBean(user);
    }
}
