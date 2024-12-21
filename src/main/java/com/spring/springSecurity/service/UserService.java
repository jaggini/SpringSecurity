package com.spring.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.springSecurity.model.User;
import com.spring.springSecurity.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        // Create a UserDetails object for Spring Security
        // UserDetails userDetails = User.builder()
        // .username(user.getEmail())
        // .password(user.getPassword())
        // .authorities(user.getAuthorities())
        // .build();
        // }

        return user;
    }

    public void saveuser(User u) {

        userRepository.save(u);
    }
}
