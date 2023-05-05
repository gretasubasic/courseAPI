package com.example.courseDemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> userOptional = userRepository.findByUsername(username);

        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found for username: " + username);
        }
        MyUser user = userOptional.get();

        System.out.println(user.getUserRoles());

        MyUserDetails userDetails = new MyUserDetails(user);
        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getPassword());
        System.out.println(user.getPassword());
        userDetails.setActive(user.isActive());
        userDetails.setRoles(user.getUserRoles());

        return userDetails;
    }
}
